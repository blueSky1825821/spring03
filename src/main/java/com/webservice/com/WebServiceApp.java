package com.webservice.com;


import org.apache.log4j.Logger;

import javax.xml.ws.Endpoint;


/**
 * Created by sky on 16-7-19.
 */
public class WebServiceApp {
    private static final Logger log = Logger.getLogger("webapp");
    public static void main(String[] args) {
        log.error("ssssssss");
        System.out.println("web service start");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address="http://localhost:10000/helloWorld";
        Endpoint.publish(address,implementor);
        System.out.println("web service started");

    }
}
