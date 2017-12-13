package com.utils.propertyUtil;

import java.io.*;

/**
 * @author qilin
 */
public class ConfigFileCreator {

    /**
     * 读取配置文件,并替换产生数据源配置文件
     */
    public static String createConfigFile(String loadPath,String targetFileName) {
        String cfgFile = readConfigFile(loadPath);
        String cfgStorePath = ConfigFileCreator.class.getClassLoader().getResource("config").getPath();
        String targetPath = cfgStorePath + targetFileName;

        try {
            FileOutputStream outputStream = new FileOutputStream(targetPath);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");

            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(cfgFile);

            bufferedWriter.flush();

            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return targetPath;
    }

    private static String readConfigFile(String loadPath) {
        InputStream in = ConfigFileCreator.class.getResourceAsStream(loadPath);
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(in, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            String separator = System.getProperty("line.separator");
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + separator);
            }
            bufferedReader.close();
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
