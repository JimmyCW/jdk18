package com.wx.jddk.jdk8;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weixing
 * @date 2019/3/18
 **/
public class FileReaderTe {

    public static void main(String[] args) throws IOException {

        File file = new File("e:\\a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb = new StringBuilder("");
        String temp = "";
        while((temp = bufferedReader.readLine()) != null) {
            sb.append(temp);
        }
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = fileInputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0 , len);
        }
        System.out.println(sb.toString());
        System.out.println(new String(byteArrayOutputStream.toByteArray()));

//        Executors.newFixedThreadPool();
//        Executors.newCachedThreadPool();
//        Executors.newSingleThreadExecutor();
//        Executors.newScheduledThreadPool()

    }
}
