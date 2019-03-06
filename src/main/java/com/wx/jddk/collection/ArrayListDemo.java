package com.wx.jddk.collection;

import com.alibaba.fastjson.JSONObject;

/**
 * @author weixing
 * @date 2019/3/5
 **/
public class ArrayListDemo {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = new int[2];
        System.arraycopy(a, 1 ,b,1,1);
        System.out.println(JSONObject.toJSONString(b));
    }
}
