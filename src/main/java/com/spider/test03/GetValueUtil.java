package com.spider.test03;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by wuyiwen on 2016/7/11.
 */
public class GetValueUtil {

    private GetValueUtil(){
        throw new Error("不要实例化工具类！");
    }

    //取字段值
    public static String getValue(final String soapStr,String parm) {
        if (StringUtils.isBlank(soapStr)) {
            return null;
        }
        int sIndex = soapStr.indexOf("<"+parm+">");
        if (sIndex < 0) {
            return null;
        }
        int eIndex = soapStr.indexOf("</"+parm+">");
        return soapStr.substring(sIndex+parm.length()+2, eIndex);
    }

    //取字段列表
    public static List<String> getValueList(final String soapStr,String param, String secondNodeName){
        List<String> list = Lists.newArrayList();

        if (StringUtils.isBlank(soapStr)) {
            return null;
        }

        String[] li = soapStr.split(secondNodeName);
        for(int i =0; i < li.length; i++){
            list.add(getValue(li[i], param));
        }

        return list;
    }
    /**
     * 截取返回需要的结果Response的xml
     * @param soapStr
     * @return
     */
    public static String parseSOAPResponse(String soapStr) {
        if (StringUtils.isBlank(soapStr)) {
            return null;
        }
        int sIndex = soapStr.indexOf("<Response>");
        if (sIndex < 0) {
            return soapStr;
        }
        int eIndex = soapStr.indexOf("</Response>");
        return soapStr.substring(sIndex, eIndex + 11);
    }

    /**
     * 截取返回需要的结果Response的xml
     * @param soapStr
     * @return
     */
    public static String parseSOAPResponseTZ(String soapStr) {
        if (StringUtils.isBlank(soapStr)) {
            return null;
        }
        int sIndex = soapStr.indexOf("<rowset>");
        if (sIndex < 0) {
            return soapStr;
        }
        int eIndex = soapStr.indexOf("</rowset>");
        return soapStr.substring(sIndex, eIndex + 9);
    }

    public static void main(String[] args) {
        String xml="<Root><Response><ResultCode>0</ResultCode><ErrorMsg>获取检验检查列表成功成功</ErrorMsg><ResultData><RecordList><RecordInfo><reportId>143008</reportId><patientId>0000055218</patientId><patientName>杨阳</patientName><age>35</age><sex>男</sex><cardNo>000017006983</cardNo><cardType>2</cardType><inhospId></inhospId><examType>大肝功</examType><checkPart></checkPart><checkDoc></checkDoc><sendTime>2017-02-23 08:17:45</sendTime><resultTime>2017-02-23 10:03:08</resultTime><printTimes>0</printTimes><inspectDoctor></inspectDoctor><auditTime></auditTime><examItem><itemName>总胆红素</itemName><itemRealValue>B0390</itemRealValue><itemRefRange>3.4-28</itemRefRange><itemMark>N</itemMark><itemUnits>umol/L</itemUnits><reportId>145473</reportId><quaResult>13.8</quaResult><itemAbbr>TBIL</itemAbbr></examItem><examItem><itemName>直接胆红素</itemName><itemRealValue>B0400</itemRealValue><itemRefRange>0-10</itemRefRange><itemMark>N</itemMark><itemUnits>umol/L</itemUnits><reportId>145473</reportId><quaResult>2.9</quaResult><itemAbbr>DBIL</itemAbbr></examItem><examItem><itemName>间接胆红素</itemName><itemRealValue>B0420</itemRealValue><itemRefRange>0-17</itemRefRange><itemMark>N</itemMark><itemUnits>umol/L</itemUnits><reportId>145473</reportId><quaResult>10.9</quaResult><itemAbbr>IBIL</itemAbbr></examItem><examItem><itemName>总蛋白(TP)测定</itemName><itemRealValue>B0430</itemRealValue><itemRefRange>55-85</itemRefRange><itemMark>N</itemMark><itemUnits>g/L</itemUnits><reportId>145473</reportId><quaResult>74.0</quaResult><itemAbbr>TP</itemAbbr></examItem><examItem><itemName>白蛋白(Alb)测定</itemName><itemRealValue>B0440</itemRealValue><itemRefRange>35-55</itemRefRange><itemMark>N</itemMark><itemUnits>g/L</itemUnits><reportId>145473</reportId><quaResult>44.9</quaResult><itemAbbr>ALB</itemAbbr></examItem><examItem><itemName>球蛋白</itemName><itemRealValue>B0450</itemRealValue><itemRefRange>20-35</itemRefRange><itemMark>N</itemMark><itemUnits>g/L</itemUnits><reportId>145473</reportId><quaResult>29.1</quaResult><itemAbbr>GLO</itemAbbr></examItem><examItem><itemName>丙氨酸氨基转移酶</itemName><itemRealValue>B0470</itemRealValue><itemRefRange>0-40</itemRefRange><itemMark>N</itemMark><itemUnits>U/L</itemUnits><reportId>145473</reportId><quaResult>22</quaResult><itemAbbr>ALT</itemAbbr></examItem><examItem><itemName>天门冬氨酸氨基转移酶</itemName><itemRealValue>B0480</itemRealValue><itemRefRange>0-40</itemRefRange><itemMark>N</itemMark><itemUnits>U/L</itemUnits><reportId>145473</reportId><quaResult>18</quaResult><itemAbbr>AST</itemAbbr></examItem><examItem><itemName>碱性磷酸酶</itemName><itemRealValue>B0490</itemRealValue><itemRefRange>37-150</itemRefRange><itemMark>N</itemMark><itemUnits>U/L</itemUnits><reportId>145473</reportId><quaResult>49</quaResult><itemAbbr>ALP</itemAbbr></examItem><examItem><itemName>γ-谷氨酰基转移酶</itemName><itemRealValue>B0500</itemRealValue><itemRefRange>8-58</itemRefRange><itemMark>N</itemMark><itemUnits>U/L</itemUnits><reportId>145473</reportId><quaResult>17</quaResult><itemAbbr>GGT</itemAbbr></examItem><examItem><itemName>总胆汁酸</itemName><itemRealValue>B0510</itemRealValue><itemRefRange>0-15</itemRefRange><itemMark>N</itemMark><itemUnits>umol/L</itemUnits><reportId>145473</reportId><quaResult>1.4</quaResult><itemAbbr>TBA</itemAbbr></examItem><examItem><itemName>胆碱脂酶测定</itemName><itemRealValue>B0770</itemRealValue><itemRefRange>3850-12000</itemRefRange><itemMark>N</itemMark><itemUnits>U/L</itemUnits><reportId>145473</reportId><quaResult>10057.00</quaResult><itemAbbr>CHE</itemAbbr></examItem><examItem><itemName>α-L-岩藻糖苷酶(AFU)</itemName><itemRealValue>B0820</itemRealValue><itemRefRange>3-40</itemRefRange><itemMark>N</itemMark><itemUnits>U/L</itemUnits><reportId>145473</reportId><quaResult>24.40</quaResult><itemAbbr>AFU</itemAbbr></examItem></RecordInfo><RecordInfo><reportId>143018</reportId><patientId>0000055218</patientId><patientName>杨阳</patientName><age>35</age><sex>男</sex><cardNo>000017006983</cardNo><cardType>2</cardType><inhospId></inhospId><examType>乙型肝炎病毒脱氧核糖核酸扩增定量检测</examType><checkPart></checkPart><checkDoc></checkDoc><sendTime>2017-02-23 08:17:45</sendTime><resultTime> </resultTime><printTimes>0</printTimes><inspectDoctor></inspectDoctor><auditTime></auditTime></RecordInfo></RecordList></ResultData></Response></Root>";

        xml=parseSOAPResponse(xml);
        System.out.print(xml);
    }


    /**
     * 截取返回需要的结果xml
     * @param soapStr
     * @return
     */
    public static  String parseOTHERResponse(String soapStr,String root) {
        if (StringUtils.isBlank(soapStr)) {
            return null;
        }
        int sIndex = soapStr.indexOf("<"+root+">");
        if (sIndex < 0) {
            return null;
        }
        int eIndex = soapStr.indexOf("</"+root+">");
        String rootStr=soapStr.substring(sIndex, (eIndex+root.length()+3));

        return rootStr;
    }


    /**
     * 截取返回需要的结果xml
     * @param soapStr
     * @return
     */
    public static  String parseOTHERResponseforSe(String soapStr,String root) {
        if (StringUtils.isBlank(soapStr)) {
            return null;
        }
        int sIndex = soapStr.indexOf("<"+root);
        if (sIndex < 0) {
            return null;
        }
        int eIndex = soapStr.indexOf("</"+root+">");
        String rootStr=soapStr.substring(sIndex, (eIndex+root.length()+3));

        return rootStr;
    }


    /**
     * 解析返回Json字符串是否正确
     *
     * @param response
     * @return
     */
    public static String getErrorMsg(String response) {
        JSONObject resultPer = JSONObject.parseObject(response);
        if(resultPer==null){
            return "预结算返回为空";
        }
        JSONObject jsonObjectPer = resultPer.getJSONObject("data");
        Boolean success = resultPer.getBoolean("success");
        String msg = resultPer.getString("msg");
        if (!success || jsonObjectPer == null) {
            return msg;
        }
        return "ok";
    }



}
