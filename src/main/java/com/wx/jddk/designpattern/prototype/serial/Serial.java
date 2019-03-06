package com.wx.jddk.designpattern.prototype.serial;

import java.io.*;

/**
 * @author weixing
 * @date 2019/2/18
 **/
public class Serial implements Serializable, Cloneable {
    private static final long serialVersionUID = 2938140190635409636L;

    private String str;

    public Serial(String str) {
        this.str = str;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }


    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Serial serial = new Serial("a");
        Object obj1 = serial.clone();
        Object obj2 = serial.deepClone();
        System.out.println(serial);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
