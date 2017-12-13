package com.spider.test03;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * http 服务调用
 *
 * @author johny
 */
public class HttpInvokeUtil {

    private static Logger log = LoggerFactory.getLogger("webparams");

    /**
     * 发送http post请求
     *
     * @param uri
     * @param requestParams
     * @return
     */
    public static Result<String> post(String uri, String requestParams, String contextType) {
        String requestId = DateTime.now().getMillis() + "|" + UUIDUtil.newGUID().substring(0, 10);
        log.error("请求参数rquest[{}] ,url is {}, params is {}", requestId, uri, requestParams);
        Result<String> result = Result.createSuccessResult();
        try {
            HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
            HttpRequest request = new HttpRequest(HttpResultType.BYTES);
            // 设置编码集
            request.setCharset(SecurityConfig.input_charset);
            request.setParameteStr(requestParams);
            request.setUrl(uri);
            HttpResponse response = httpProtocolHandler.execute(request, "", "", contextType);
            result.value(response.getStringResult());
            if (response.getStringResult().length() <= 5000) {
                log.error("返回参数result[" + requestId + "]:" + response.getStringResult() + ",status: " + response.getStatusCode());
            } else {
                log.error("返回参数result[" + requestId + "]:" + response.getStringResult().substring(0, 5000) + ",status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            log.error("请求参数request [{}]HttpInvokeUtil error, {}", requestId, e.fillInStackTrace());
            result.error(Result.SERVER_EXCEPTION, e.getMessage());
        }
        return result;
    }

    /**
     * 发送http post请求
     *
     * @param uri
     * @param sPara
     * @return
     */
    public static Result<String> post(String flowId, String uri, Map<String, String> sPara, String contextType) {
        String traceId = DateTime.now().getMillis() + "|" + UUIDUtil.newGUID().substring(0, 10);
        log.error("flowId={}, traceId={} ,url is {}, params is {}", flowId, traceId, uri, sPara);
        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
        Result<String> result = Result.createSuccessResult();
        // 设置编码集
        request.setCharset(SecurityConfig.input_charset);
        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(uri);
        try {
            HttpResponse response = httpProtocolHandler.execute(request, "", "", contextType);
            if (response.getStringResult().length() <= 5000) {
                log.error("traceId=" + traceId + "," + response.getStringResult() + ",status=" + response.getStatusCode());
            } else {
                log.error("traceId=" + traceId + "," + response.getStringResult().substring(0, 5000) + ",status=" + response.getStatusCode());
            }
            if (response.getStatusCode() == 200) {
                result.value(response.getStringResult());
            } else if (response.getStatusCode() == 500) {
                result.error(Result.SERVER_EXCEPTION, "服务端调用异常");
            } else {
                result.error(response.getStringResult());
            }

        } catch (Exception e) {
            log.error(" request [{}]HttpInvokeUtil error, {}", traceId, e.fillInStackTrace());
            result.error(Result.TIMEOUT_EXCEPTION, e.getMessage());
        }
        return result;
    }

    /**
     * 重庆发送http post请求
     *
     * @param uri
     * @param sPara
     * @return
     */
    public static Result<String> postCq(String flowId, String skey, String uri, Map<String, String> sPara, String contextType) {

        String traceId = DateTime.now().getMillis() + "|" + UUIDUtil.newGUID().substring(0, 10);
        String req = null;
        try {
            req = deCrypt(sPara.get("ReData"), skey);
        } catch (Exception e) {
            log.error("postCq req ", e);
        }
        log.error("flowId={}, traceId={} ,url is {}, params is {}", flowId, traceId, uri, req);
        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
        Result<String> result = Result.createSuccessResult();
        // 设置编码集
        request.setCharset(SecurityConfig.input_charset);
        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(uri);
        try {
            HttpResponse response = httpProtocolHandler.execute(request, "", "", contextType);
            String res = null;
            try {
                res = deCrypt(response.getStringResult(), skey);
            } catch (Exception e) {
                log.error("postCq rs error", response.getStringResult());
            }
            if(StringUtils.isEmpty(res)){
                res=response.getStringResult();
            }

            log.error("traceId=" + traceId + "," + res + ",status=" + response.getStatusCode());
            if (response.getStatusCode() == 200) {
                result.value(response.getStringResult());
            } else if (response.getStatusCode() == 500) {
                result.error(Result.SERVER_EXCEPTION, "服务端调用异常");
            } else {
                result.error(response.getStringResult());
            }

        } catch (Exception e) {
            log.error(" request [{}]HttpInvokeUtil error, {}", traceId, e.fillInStackTrace());
            result.error(Result.TIMEOUT_EXCEPTION, e.getMessage());
        }
        return result;
    }

    /**
     * 发送http post请求
     *
     * @param uri
     * @param sPara
     * @return
     */
    @Deprecated
    public static Result<String> post(String uri, Map<String, String> sPara, String contextType) {
        String traceId = DateTime.now().getMillis() + "|" + UUIDUtil.newGUID().substring(0, 10);
        log.error("请求参数rquest[{}] ,url is {}, params is {}", traceId, uri, sPara);
        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
        Result<String> result = Result.createSuccessResult();
        // 设置编码集
        request.setCharset(SecurityConfig.input_charset);
        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(uri);
        try {
            HttpResponse response = httpProtocolHandler.execute(request, "", "", contextType);
            if (response.getStringResult().length() <= 5000) {
                log.error("返回参数result[" + traceId + "]:" + response.getStringResult() + ",status: " + response.getStatusCode());
            } else {
                log.error("返回参数result[" + traceId + "]:" + response.getStringResult().substring(0, 5000) + ",status: " + response.getStatusCode());
            }
            if (response.getStatusCode() == 200) {
                result.value(response.getStringResult());
            } else if (response.getStatusCode() == 500) {
                result.error(Result.SERVER_EXCEPTION, "服务端调用异常");
            } else {
                result.error(response.getStringResult());
            }
        } catch (Exception e) {
            log.error("请求参数request [{}]HttpInvokeUtil error, {}", traceId, e.fillInStackTrace());
            result.error(Result.TIMEOUT_EXCEPTION, e.getMessage());
        }
        return result;
    }

    /**
     * MAP类型数组转换成NameValuePair类型
     *
     * @param properties MAP类型数组
     * @return NameValuePair类型数组
     */
    private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }

        return nameValuePair;
    }

    private static  String deCrypt(String xml,String key){

        String data = GetValueUtil.getValue(xml, "DATAPARAM").trim();
        String res = data.substring(9, data.length() - 3);
        String decrypt = null;
        try {
            decrypt = AESUtil.Decrypt(res,key);
        } catch (Exception e) {
            log.error("decrypt xml failure for cq");
        }

        return decrypt;
    }

    public static void main(String[] args) {
        get("http://api.aliyun.yuantutech.com/user-web/openapi/getSettlementLog", "apiNo=1001011000&appId=150&currentPage=1&endTime=2017-06-10+00%3A00%3A00&hisCode=3306011247&pageSize=10&parentCorpId=150&sign=18A88EBEB9B8E9AB5497B3F118920FC5&startTime=2017-03-09+00%3A00%3A00&tradeChannel=ZFB", HttpProtocolHandler.HTML);
        Result res = post("http://plan.uat.ali.yuantutech.com:9001/plancenter/rest/api/schDept", "1",
                MapBuilder.init("corpCode", "3702011121").put("corpId", "261").put("startDate", "2017-07-04").put("endDate", "2017-07-04").build(),
                HttpProtocolHandler.HTML);
//        res.setMsg(res.errorMess());
        System.out.println(res);
    }

    /**
     * 发送http get请求
     *
     * @param uri
     * @param requestParams
     * @return
     */
    public static Result<String> get(String uri, String requestParams, String contextType) {
        String traceId = DateTime.now().getMillis() + "|" + UUIDUtil.newGUID().substring(0, 10);
        log.error("flowId={}, traceId={} ,url is {}, params is {}", "", traceId, uri, requestParams);
        Result<String> result = Result.createSuccessResult();
        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
        HttpRequest request = new HttpRequest(HttpResultType.STRING);
        request.setMethod(HttpRequest.METHOD_GET);
        // 设置编码集
        request.setCharset(SecurityConfig.input_charset);
        request.setQueryString(requestParams);
        request.setUrl(uri);
        try {
            HttpResponse response = httpProtocolHandler.execute(request, "", "", contextType);
            if (response.getStatusCode() > 400) {
                result.error(Result.SERVER_EXCEPTION, "");
            } else {
                result.value(response.getStringResult());
            }
            log.error("traceId=" + traceId + ",his result:" + response.getStringResult() + ",status: " + response.getStatusCode());
        } catch (Exception e) {
            log.error("HttpInvokeUtil error,", e);
            result.error(Result.SERVER_EXCEPTION, e.getMessage());
        }
        return result;
    }
}
