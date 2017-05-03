package com.threadTest.thread.test04;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.net.SocketTimeoutException;

/**
 * Created by sky on 2017/3/9.
 */
public class ThreadPost extends Thread {
    String s = "";

    @Override
    public void run() {
        String url = "http://10.130.107.11:8081/KWSService.asmx?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        Object[] objects = new Object[]{"QueryPatient", "<Request><cardNo>1212163571</cardNo><cardType>2</cardType></Request>", ""};
        try {
            Object[] objects1 = client.invoke("WebBusiness", objects);
            s = objects1[1].toString().trim();
            System.out.println(s);
        } catch (SocketTimeoutException se1) {
            System.out.println("超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(s);
    }

    public static void main(String[] args) {
        ThreadPost a = new ThreadPost();
        a.start();
        ThreadPost[] thread = new ThreadPost[100];
        for (int i = 1; i < 50; i++) {
            thread[i] = new ThreadPost();
            long start = System.currentTimeMillis();
            thread[i].start();
            System.out.println(Thread.currentThread().getName() + " " + (System.currentTimeMillis() - start));
        }
    }
}
