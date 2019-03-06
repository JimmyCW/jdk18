package com.wx.jddk.designpattern.prototype.clone;

/**
 * @author weixing
 * @date 2019/2/18
 **/
public class Prototype implements Cloneable {

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Prototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype1 = new Prototype("a");
        Prototype prototype2 = (Prototype) prototype1.clone();
        System.out.println(prototype1.getName());
        System.out.println(prototype2.getName());
        System.out.println(prototype1.equals(prototype2));
    }
}
