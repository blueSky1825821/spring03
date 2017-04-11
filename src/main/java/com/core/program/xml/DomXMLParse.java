package com.core.program.xml;

import com.alibaba.druid.util.StringUtils;
import org.junit.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by sky on 2017/4/7.
 */
public class DomXMLParse {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        File file = new File("F:\\myObjectFile.xml");
        try {
            Document doc = builder.parse(file);
            Element root = doc.getDocumentElement();
            String rootName = root.getTagName();
            NodeList children = root.getChildNodes();
            NodeList ResultData = root.getElementsByTagName("ResultData");
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child instanceof Element) {
                    Element childElement = (Element) child;
                    if (StringUtils.equals("ResultCode", childElement.getTagName())) {
                        System.out.println("ResultCode: " + childElement.getTextContent());
                    }
                    if (StringUtils.equals("ErrorMsg", childElement.getTagName())) {
                        System.out.println("ErrorMsg: " + childElement.getTextContent());
                    }
                    //获取属性 或者childElement.getAttribute("");
                    NamedNodeMap attributes = childElement.getAttributes();
                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node attribute = attributes.item(i);
                        String name = attribute.getNodeName();
                        String value = attribute.getNodeValue();
                    }
                    childElement.getTagName();
                    Node first = childElement.getFirstChild();
                    System.out.println();
                }

                if (StringUtils.equals("ResultData", child.getNodeName())) {
                    NodeList childList = child.getChildNodes();
                    for (int k = 0; k < childList.getLength(); k++) {
                        //RecordList
                        Node childNode = childList.item(k);
                        if (childNode instanceof Element) {
                            Element childNodeElement = (Element) childNode;
                            NodeList nl = childNodeElement.getChildNodes();
                            for (int m = 0; m < childList.getLength(); m++) {
                                //RecordInfo
                                Node nlList = nl.item(m);
                                if (nlList instanceof Element) {
                                    Element nlListElement = (Element) nlList;
                                    NodeList nlListElementChildNodes = nlListElement.getChildNodes();
                                    for (int j = 0; j < nlListElementChildNodes.getLength(); j++) {
                                        //doctList
                                        Node nlListElementChildNode = nlListElementChildNodes.item(j);
                                        if (nlListElementChildNode instanceof Element) {

                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }

            for (int i = 0; i < ResultData.getLength(); i++) {
                Node child = ResultData.item(i);
                if (StringUtils.equals("ResultData", child.getNodeName())) {
                    NodeList childList = child.getChildNodes();
                    for (int k = 0; k < childList.getLength(); k++) {
                        Node childNode = childList.item(k);

                    }
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
