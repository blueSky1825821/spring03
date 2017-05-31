package com.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sky on 2017/5/24.
 * url 连接、获取内容
 */
public class URLUtilUp {
    /**
     * 获取连接
     * @param urlString
     * @param destFile
     */
    public static void urlReader(String urlString, File destFile) {
        try {
            //url = new URL("http://www.yiibai.com");
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter
                    (new FileWriter(destFile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
