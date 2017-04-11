package com.utils;

import com.common.MACUtil;
import com.common.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * Socket 服务调用
 *
 * @author johnyn
 */
public class SocketInvokeUtil {

    private static Logger logger = LoggerFactory.getLogger(SocketInvokeUtil.class);

    /**
     * 广东广州番禺中心医院处理
     *
     * @param socket
     * @param requestParams
     * @param charsetName
     * @return
     */
    public static Result<String> postGdGzPy(Socket socket, String requestParams, String charsetName) {
        Result<String> result = Result.createSuccessResult();
        try {
            BufferedWriter bw = sendRequestXml(requestParams, socket, charsetName);
            String rexml = acceptData(socket, charsetName);
            // 关闭输入流
            bw.close();
            // 特殊加工一下：
            if (StringUtils.isNotBlank(rexml)) {
                rexml = rexml.substring(rexml.indexOf("<ROOT"));
            }
            return result.value(rexml);
        } catch (IOException e) {
            logger.error(" SocketInvokeUtil post error", e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                logger.error(" socket close error");
            }
        }
        return null;
    }

    /**
     * 发送请求参数
     *
     * @param requestParams
     * @param socket
     * @param charsetName
     * @throws IOException
     */
    private static BufferedWriter sendRequestXml(String requestParams, Socket socket, String charsetName)
            throws IOException {
        try {
            if (StringUtils.isNotBlank(requestParams)) {
                requestParams = requestParams.replaceAll("(\r\n|\r|\n|\n\r)", "");
                requestParams = requestParams.trim();
            }
            System.out.println("send xml :" + requestParams);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetName));
            bw.write(requestParams);
            bw.flush();
            return bw;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String acceptData(Socket socket, String charsetName) {

        char[] data = new char[1024 * 1024];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), charsetName));
            int a = 0;
            String rexml = "";
            while ((a = br.read(data)) != -1) {
                rexml += new String(data);
            }
            if (StringUtils.isNotBlank(rexml)) {
                rexml = rexml.replaceAll("(\r\n|\r|\n|\n\r)", "");
                rexml = rexml.trim();
            }
            // 关闭流
            br.close();
            return rexml;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 广东深圳银医平台处理
     *
     * @param socket
     * @param requestParams
     * @param charsetName
     * @return
     */
    public static Result<String> postForSZ(Socket socket, String requestParams, String charsetName) {
        Result<String> result = Result.createFailResult();
        String errorMsg = null;
        try {
            BufferedWriter bw = sendRequestXmlForSZ(requestParams, socket, charsetName);
            String rexml = acceptDataForSZ(socket, charsetName);
            logger.error("his ret ={}", rexml);
            // 关闭输入流
            bw.close();
            // 特殊加工一下：
            if (StringUtils.isNotBlank(rexml)) {
                rexml = rexml.substring(rexml.indexOf("<ROOT"));
            }
            return result.value(rexml);
        } catch (IOException e) {
            errorMsg = e.getMessage();
            logger.error(" SocketInvokeUtil post error", e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                errorMsg = e.getMessage();
                logger.error(" socket close error", e);
            }
        }
        return result.error(errorMsg);
    }

    /**
     * 发送请求参数
     *
     * @param requestParams
     * @param socket
     * @param charsetName
     * @throws IOException
     */
    private static BufferedWriter sendRequestXmlForSZ(String requestParams, Socket socket, String charsetName) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetName));
            bw.write(requestParams);
            bw.flush();
            return bw;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String acceptDataForSZ(Socket socket, String charsetName) {

        char[] data = new char[1024 * 1024];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), charsetName));
            int a = 0;
            String rexml = "";
            while ((a = br.read(data)) != -1) {
                rexml += new String(data);
            }
            if (StringUtils.isNotBlank(rexml)) {
                rexml = rexml.replaceAll("(\r\n|\r|\n|\n\r)", "");
                rexml = rexml.trim();
            }
            // 关闭流
            br.close();
            return rexml;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
//        String rexml2 ="<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT type=”request”><TR_CODE>1001</TR_CODE><CHN_NO>S</CHN_NO><HIS_DT>20160509</HIS_DT><HIS_TM>154510</HIS_TM><HIS_LIST>3038123456800</HIS_LIST><MERC_NO>07550301</MERC_NO><CYC_CNT>0</CYC_CNT><HOSP_NO>265</HOSP_NO><CARD_TYPE_ID>5</CARD_TYPE_ID><CARD_NO>12345678</CARD_NO><PWD></PWD><ID_TYPE>001</ID_TYPE><ID_NO>123456789012345678</ID_NO><SICK_NAME>test1</SICK_NAME><SICK_SEX>1</SICK_SEX><SICK_TEL>12345678901</SICK_TEL><SICK_ADDR>杭州市</SICK_ADDR><BIRTH_DAY>20001010</BIRTH_DAY><BANK_CARD_NO>12345678901234567890</BANK_CARD_NO><TERM_ID></TERM_ID></ROOT>";
//        String rexml2 = "<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT type=\"response\"><TR_CODE>2023</TR_CODE><HIS_DT>20160511</HIS_DT><HIS_TM>170123</HIS_TM><HIS_LIST>2023011103000105102</HIS_LIST><CHN_NO>S</CHN_NO><MERC_NO>0111030000051</MERC_NO><TERM_ID>0103YT0001</TERM_ID><CYC_CNT>0</CYC_CNT><CARD_TYPE_ID>5</CARD_TYPE_ID><CARD_NO>6226900301154296</CARD_NO><BANK_CARD_NO>6226900301154296</BANK_CARD_NO><TR_AMT>34.56</TR_AMT><HOSP_NO>0111030000051</HOSP_NO></ROOT>";
//        String rexml2 = "<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT type=\"response\"><TR_CODE>1010</TR_CODE><HIS_DT>20160512</HIS_DT><HIS_TM>154511</HIS_TM><HIS_LIST>1010011103000005120</HIS_LIST><CHN_NO>S</CHN_NO><MERC_NO>0111030000051</MERC_NO><TERM_ID>0103YT0001</TERM_ID><CYC_CNT>0</CYC_CNT><CARD_TYPE_ID>5</CARD_TYPE_ID><CARD_NO>6226900301154296</CARD_NO><PWD_FLAG>1</PWD_FLAG><PWD>ab32c4f82b3787b1</PWD><ID_TYPE>101</ID_TYPE><ID_NO>110108196104010174</ID_NO><SICK_NAME>中信测试二</SICK_NAME><NEW_ID_TYPE>101</NEW_ID_TYPE><NEW_ID_NO>110108196104010174</NEW_ID_NO><NEW_NAME>中信测试二</NEW_NAME><SICK_TEL>13800138137</SICK_TEL><SICK_ADDR>深圳市罗湖区南湖路兴隆大厦裙楼1楼</SICK_ADDR><HOSP_NO>0111030000051</HOSP_NO><TERMDEVID>0103YT0001</TERMDEVID><PRI_AC_NO>6226900301154296</PRI_AC_NO></ROOT>";
        String rexml2 = "<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT type=\"response\">" +
                "<TR_CODE>1001</TR_CODE><HIS_DT>20160510</HIS_DT><HIS_TM>162015</HIS_TM>" +
                "<HIS_LIST>1001011103000005202</HIS_LIST><CHN_NO>S</CHN_NO><MERC_NO>0111030000051</MERC_NO>" +
                "<TERM_ID>0103YT0001</TERM_ID><CYC_CNT>0</CYC_CNT><HOSP_NO>0111030000051</HOSP_NO>" +
                "<CARD_TYPE_ID>5</CARD_TYPE_ID><CARD_NO>6226900301154201</CARD_NO>" +
                "<PWD></PWD><ID_TYPE>101</ID_TYPE>" +
                "<ID_NO>110108196104010201</ID_NO><SICK_NAME>远图测试二</SICK_NAME>" +
                "<SICK_TEL>13800138201</SICK_TEL>" +
                "<SICK_ADDR>深圳市罗湖区南湖路兴隆大厦裙楼2楼</SICK_ADDR><BANK_CARD_NO>" +
                "</BANK_CARD_NO><BANK_CARD_PWD></BANK_CARD_PWD><PRI_AC_NO>6226900301154296</PRI_AC_NO>" +
                "<TERMDEVID>0103YT0001</TERMDEVID></ROOT>";
        String veckor = "0000000000000000";
        String key = "12121212121212121212121212121212";

        String mac = MACUtil.mac919(key, veckor, rexml2);
        String request = rexml2.replace("</ROOT>", "<SIGN>" + mac + "</SIGN></ROOT>");
        System.out.println("request is :" + request);
//        String rexml3 = rexml2.substring(rexml2.indexOf("<ROOT"));
//        System.err.println(rexml3);
//        invokeSocket("s");
        Socket socket = new Socket("45.33.117.213", 19045);
        String length = String.format("%05d", request.getBytes("GBK").length);
        Result result = postGdGzPy(socket, length + request, "GBK");
        System.out.println("value:" + result.value());
        System.out.println("msg:" + result.getMsg());

    }


}
