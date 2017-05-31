package com.yiibai.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by sky on 2017/5/24.
 */
public class UrlProtocol {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.server.com");
            System.out.println("URL is " + url.toString());
            System.out.println("protocol is " + url.getProtocol());
            System.out.println("file name is " + url.getFile());
            System.out.println("host is " + url.getHost());
            System.out.println("path is " + url.getPath());
            System.out.println("port is " + url.getPort());
            System.out.println("defualt port is " + url.getDefaultPort());

            //HttpURLConnection类的httpCon.getDate()方法来获取URL连接的日期。
            URL url1 = new URL("http://www.baidu.com");
            HttpURLConnection httpCon =
                    (HttpURLConnection) url1.openConnection();
            long date = httpCon.getDate();
            if (date == 0)
                System.out.println("No date information.");
            else
                System.out.println("Date: " + new Date(date));

            URL url2 = new URL("http://www.yiibai.com");
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(url2.openStream()));
            BufferedWriter writer = new BufferedWriter
                    (new FileWriter("data.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println(".........");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
