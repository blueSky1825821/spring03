package com.spider.test03;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/*
 * * 类名：HttpProtocolHandler 功能：HttpClient方式访问 详细：获取远程HTTP数据 版本：3.3 日期：2012-08-17 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class HttpProtocolHandler {

  private static String DEFAULT_CHARSET = "GBK";

  /** 连接超时时间，由bean factory设置，缺省为8秒钟 */
  private int defaultConnectionTimeout = 8000 * 2;

  /** 回应超时时间, 由bean factory设置，缺省为30秒钟 */
  private int defaultSoTimeout = 30000 * 8;

  /** 闲置连接超时时间, 由bean factory设置，缺省为60秒钟 */
  private int defaultIdleConnTimeout = 60000 * 2;

  private int defaultMaxConnPerHost = 30;

  private int defaultMaxTotalConn = 80;

  /** 默认等待HttpConnectionManager返回连接超时（只有在达到最大连接数时起作用）：1秒 */
  private static final long defaultHttpConnectionManagerTimeout = 3 * 1000;

  public static final String HTML = "application/x-www-form-urlencoded;text/html;";

  public static final String JSON = "application/json;";

  /**
   * HTTP连接管理器，该连接管理器必须是线程安全的.
   */
  private HttpConnectionManager connectionManager;

  private static HttpProtocolHandler httpProtocolHandler = new HttpProtocolHandler();

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 工厂方法
   * 
   * @return
   */
  public static HttpProtocolHandler getInstance() {
    return httpProtocolHandler;
  }

  /**
   * 私有的构造方法
   */
  private HttpProtocolHandler() {
    // 创建一个线程安全的HTTP连接池
    connectionManager = new MultiThreadedHttpConnectionManager();
    connectionManager.getParams().setDefaultMaxConnectionsPerHost(defaultMaxConnPerHost);
    connectionManager.getParams().setMaxTotalConnections(defaultMaxTotalConn);

    IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
    ict.addConnectionManager(connectionManager);
    ict.setConnectionTimeout(defaultIdleConnTimeout);
    ict.start();
  }

  /**
   * 执行Http请求
   * 
   * @param request 请求数据
   * @param strParaFileName 文件类型的参数名
   * @param strFilePath 文件路径
   * @return
   * @throws HttpException, IOException
   */
  public HttpResponse execute(HttpRequest request, String strParaFileName, String strFilePath, String applicationType)
      throws IOException {
    String url =  request.getUrl();
    String str =  request.getParameteStr();

    HttpClient httpclient = new HttpClient(connectionManager);
    // 设置连接超时
    int connectionTimeout = defaultConnectionTimeout;
    if (request.getConnectionTimeout() > 0) {
      connectionTimeout = request.getConnectionTimeout();
    }
    httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);
    // 设置回应超时
    int soTimeout = defaultSoTimeout;
    if (request.getTimeout() > 0) {
      soTimeout = request.getTimeout();
    }
    httpclient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);

    // 设置等待ConnectionManager释放connection的时间
    httpclient.getParams().setConnectionManagerTimeout(defaultHttpConnectionManagerTimeout);

    String charset = request.getCharset();
    charset = charset == null ? DEFAULT_CHARSET : charset;
    HttpMethod method = null;

    // get模式且不带上传文件
    if (request.getMethod().equals(HttpRequest.METHOD_GET)) {
      method = new GetMethod(request.getUrl());
//      method.getParams().setCredentialCharset(charset);

      method.addRequestHeader( "Content-Type", "text/html;charset=utf-8" );

      // parseNotifyConfig会保证使用GET方法时，request一定使用QueryString
      method.setQueryString(request.getQueryString());
    } else if (request.getMethod().equals(HttpRequest.METHOD_POST)) {
      // post模式且不带上传文件
      method = new PostMethod(request.getUrl());
      if (request.getParameters() == null) {
        RequestEntity requestEntity = new StringRequestEntity(request.getParameteStr(), applicationType, charset);
        ((PostMethod) method).setRequestEntity(requestEntity);
      } else {
        ((PostMethod) method).addParameters(request.getParameters());
      }

      method.addRequestHeader("Content-Type", applicationType + "charset=" + charset);
    } else {
      // post模式且带上传文件
      method = new PostMethod(request.getUrl());
      List<Part> parts = new ArrayList<Part>();
      for (int i = 0; i < request.getParameters().length; i++) {
        parts.add(new StringPart(request.getParameters()[i].getName(), request.getParameters()[i].getValue(), charset));
      }
      // 增加文件参数，strParaFileName是参数名，使用本地文件
      parts.add(new FilePart(strParaFileName, new FilePartSource(new File(strFilePath))));

      // 设置请求体
      ((PostMethod) method)
          .setRequestEntity(new MultipartRequestEntity(parts.toArray(new Part[0]), new HttpMethodParams()));
    }

    // 设置Http Header中的User-Agent属性
    method.addRequestHeader("User-agent", "Mozilla/4.0");
    HttpResponse response = new HttpResponse();

    try {
//      logger.error("Request His:"+method.toString());
      httpclient.executeMethod(method);
       response.setStatusCode(method.getStatusCode());

      if (request.getResultType().equals(HttpResultType.STRING)) {
        response.setStringResult(method.getResponseBodyAsString());
      } else if (request.getResultType().equals(HttpResultType.BYTES)) {
        response.setByteResult(method.getResponseBody());
      }
      response.setResponseHeaders(method.getResponseHeaders());
    } catch (UnknownHostException ex) {
      logger.error("UnknownHostException", ex);
      throw ex;
    } catch (IOException ex) {
      logger.error("IOException", ex);
      throw ex;
    } catch (Exception ex) {
      logger.error("Exception", ex);
      throw ex;
    } finally {
      method.releaseConnection();
    }
    return response;
  }

  /**
   * 将NameValuePairs数组转变为字符串
   * 
   * @param nameValues
   * @return
   */
  protected String toString(NameValuePair[] nameValues) {
    if (nameValues == null || nameValues.length == 0) {
      return "null";
    }

    StringBuffer buffer = new StringBuffer();

    for (int i = 0; i < nameValues.length; i++) {
      NameValuePair nameValue = nameValues[i];

      if (i == 0) {
        buffer.append(nameValue.getName() + "=" + nameValue.getValue());
      } else {
        buffer.append("&" + nameValue.getName() + "=" + nameValue.getValue());
      }
    }

    return buffer.toString();
  }
}
