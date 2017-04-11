package com.core.program.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by sky on 2017/4/10.
 * P150
 */
public class XMLWriteTest {
    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        //空白文档
        Document doc = builder.newDocument();
        //创建元素
        Element rootElement = doc.createElement("Root");
        Element childElement = doc.createElement("Request");
        //创建文本节点
        Text textNode = doc.createTextNode("textContents");
        //
        doc.appendChild(rootElement);
        rootElement.appendChild(childElement);
        childElement.appendChild(textNode);
    }
}

class XMLWriteFrame extends JFrame {

}
