package com.wx.jddk.classloader;

import java.io.*;

/**
 * @author weixing
 * @date 2019/3/13
 **/
public class MyClassLoader extends ClassLoader {
    private static final String DIR = "E:\\sthcode\\jdk18\\target\\classes";

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File file = new File(DIR, classPath + ".class");
        if(!file.exists()) {
            throw new ClassNotFoundException("class file not exist");
        }
        byte[] bytes = readFileToBytes(file);
        if(null == bytes || bytes.length == 0) {
            throw new ClassNotFoundException("null file");
        }
        return this.defineClass(name,bytes, 0, bytes.length);
    }

    private byte[] readFileToBytes(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len= 0;
            byte[] bytes = new byte[1024];
            while((len = fileInputStream.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
            return bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
