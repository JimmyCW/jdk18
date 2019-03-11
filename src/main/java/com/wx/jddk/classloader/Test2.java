package com.wx.jddk.classloader;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @author weixing
 * @date 2019/3/11
 **/
public class Test2 {
    private static String path = "C:\\Users\\wx\\Documents\\Tencent Files\\379322535\\FileRecv\\003.txt";
    public static void main(String[] args) throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jsonObject = JSON.parseObject(sb.toString());
        System.out.println(jsonObject);
    }
}
