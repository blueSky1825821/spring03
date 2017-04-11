package com.core.program.xml;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;

/**
 * Created by sky on 2017/4/9.
 * this panel uses an XML file to describe its components and their grid bag layout positions
 */
public class GridBagPane extends JPanel{
    private GridBagConstraints constraints;

    public GridBagPane(String fileName) {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        if (fileName.contains("-schema")) {
            factory.setNamespaceAware(true);
            final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/";

        }
    }

}
