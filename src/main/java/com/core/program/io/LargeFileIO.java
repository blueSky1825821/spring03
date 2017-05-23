package com.core.program.io;

import com.alibaba.fastjson.JSONObject;
import com.utils.FileUtilsUp;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by sky on 2017/4/22.
 */
public class LargeFileIO {
    public static Long largeFileIO(String inputFile, String outputFile) {
        String str = "sourceCode.*HIS.*yuantu.wap.query.patient.info";
        try {
            File iFile = new File(inputFile);
            if (iFile.isDirectory()) {
                String REGEX = "[servicelog]";
                String REGEX0 = "(yuantu.wap.query.patient.info\"|yuantu.wap.query.patient.vs.info\").*\"source\":\"HIS\"";
                String REGEX1 = "(yuantu.wap.query.patient.info\"|yuantu.wap.query.patient.vs.info\").*\"source\":\"APP\"";
                String REGEX2 = "(yuantu.wap.query.patient.info\"|yuantu.wap.query.patient.vs.info\").*\"source\":\"ZZJ\"";
                String REGEX3 = "yuantu.wap.query.patient.info\"|yuantu.wap.query.patient.vs.info\"";
                long num0all = 0;
                long num1all = 0;
                long num2all = 0;
                long numall = 0;
                long sumall = 0;
                String[] input = iFile.list();
                if (input.length > 0) {
                    Set<String> set = new HashSet<>();
                    for (int i = 0; i < input.length; i++) {
                        long num0 = 0;
                        long num1 = 0;
                        long num2 = 0;
                        long num = 0;
                        long sum = 0;
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile + File.separator + input[i]));
                        //读取10M
                        BufferedReader in = new BufferedReader(new InputStreamReader(bis, "UTF-8"), 10 * 1024 * 1024);
                        FileWriter fw = new FileWriter(outputFile);
                        while (in.ready()) {
                            String line = in.readLine();
                            sum++;
                            if (Pattern.compile(REGEX).matcher(line).find()) {
                                int a = line.indexOf(REGEX);
                                line = line.substring(a + 12);
                            }
                            if (Pattern.compile(REGEX0).matcher(line).find()) {
                                num0++;
                            } else if (Pattern.compile(REGEX1).matcher(line).find()) {
                                num1++;
                            } else if (Pattern.compile(REGEX2).matcher(line).find()) {
                                num2++;
                            }
                            if (Pattern.compile(REGEX3).matcher(line).find()) {
                                try {
                                    JSONObject obj = JSONObject.parseObject(line);
                                    if (null != obj) {
                                        String innerString = obj.getString("requestParams");
                                        JSONObject innerObj = JSONObject.parseObject(innerString);
                                        String value = innerObj.getString("cardNo");
                                        if (StringUtils.isNotBlank(value)) {
                                            set.add(value);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("转换失败");
                                }
                                num++;
                            }
                        }
                        System.out.println(inputFile + File.separator + input[i] + REGEX0 + "次数：" + num0);
                        System.out.println(inputFile + File.separator + input[i] + REGEX1 + "次数：" + num1);
                        System.out.println(inputFile + File.separator + input[i] + REGEX2 + "次数：" + num2);
                        System.out.println(inputFile + File.separator + input[i] + REGEX3 + "服务人次：" + num);
                        System.out.println(inputFile + File.separator + input[i] + "总次数：" + sum);
                        num0all += num0;
                        num1all += num1;
                        num2all += num2;
                        numall += num;
                        sumall += sum;
                    }
                    System.out.println(inputFile + "平均总次数：" + sumall / 7);
                    System.out.println(inputFile + REGEX3 + "平均服务人次：" + numall / 7);
                    System.out.println(inputFile + REGEX1 + "平均次数：" + num1all / 7);
                    System.out.println(inputFile + REGEX2 + "平均次数：" + num2all / 7);
                    System.out.println(inputFile + REGEX0 + "平均次数：" + num0all / 7);
                    System.out.println("平均cardNo数量：" + set.size() / 7);
                }
            }
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
//            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "UTF-8"), 10*1024*1024);
//            FileWriter fw = new FileWriter(outputFile);
//            while(in.ready()) {
//                String line = in.readLine();
//                if (Pattern.compile(REGEX).matcher(line).find()) {
//                    num++;
//                }
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String inputFile = "F:\\workstation\\logs\\qdzx1logs";
        String outputFile = "C:\\Users\\sky\\Desktop\\文本\\log\\logs\\1.txt";
        largeFileIO(inputFile, outputFile);
    }
}
