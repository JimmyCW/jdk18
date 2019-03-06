package com.wx.jddk.reflect.constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author weixing
 * @date 2018/10/27
 **/
public class Person {
    public Person(){};
    public Person(String name, int age){};
    public Person(String name){};
    public String name;



    public static void main(String[] args) throws Exception {
        Class<?> clazz = Person.class;
        Constructor<?>[] cons = clazz.getConstructors();
        for(Constructor constructor : cons) {
            System.out.println(constructor);
            System.out.println(Modifier.toString(constructor.getModifiers()) + " ");
        }
        Constructor<?> con = clazz.getConstructor(String.class);
        System.out.println(con);
        System.out.println(Modifier.toString(con.getModifiers()) + " ");

        Class<?> clz = Class.forName("com.wx.jddk.reflect.constructors.Person");
        Object obj = clz.newInstance();
        Method setName = clz.getMethod("setName", String.class);
        setName.invoke(obj, "aaa");
        Method getName = clz.getMethod("getName");
        Object result = getName.invoke(obj);
        System.out.println(result.toString());

        Class<?> clzField = Class.forName("com.wx.jddk.reflect.constructors.Person");
        Object objField = clzField.newInstance();
        Field field = clzField.getField("name");
        System.out.println(field.getType());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
