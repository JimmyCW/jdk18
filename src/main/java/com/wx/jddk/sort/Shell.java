package com.wx.jddk.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author weixing
 * @date 2019/3/9
 **/
public class Shell {

    public static int[] num = {5, 6, 2, 1, 2, 6, 3, 9, 7, 1, 5, 8};

    public static void main(String[] args) {
        int[] nums = {5, 6, 2, 1, 2, 6, 3, 9, 7, 1, 5, 8};
        shell3(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }

    public static void shell(int[] nums) {
        int inner, outer;
        int temp;
        int h = 1;
        while (h <= nums.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < nums.length; outer++) {
                temp = nums[outer];
                inner = outer;
                while (inner > h - 1 && nums[inner - h] >= temp) {
                    nums[inner] = nums[inner - h];
                    inner -= h;
                }
                nums[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void shell2(int[] nums) {
        System.out.println("length: " + nums.length);
        System.out.println(JSONObject.toJSONString(nums));
        System.out.println(JSONObject.toJSONString(num));
        int inner, outer, temp;
        int h = 1;
        System.out.println("h = " + h);
        while (h <= nums.length / 3) {
            h = h * 3 + 1;
            System.out.println("h = " + h);
        }
        while (h > 0) {
            for (outer = h; outer < nums.length; outer++) {
                temp = nums[outer];
                inner = outer;
                System.out.println(String.format("temp:%d , inner:%d ", temp, inner));
                System.out.println(String.format("inner:%d > h:%d - 1", inner, h));
                while (inner > h - 1 && nums[inner - h] >= temp) {
                    nums[inner] = nums[inner - h];
                    inner -= h;
                    System.out.println(JSONObject.toJSONString(nums));
                    System.out.println(JSONObject.toJSONString(num));
                    System.out.println(String.format("inner:%d", inner));
                }
                nums[inner] = temp;
                System.out.println(JSONObject.toJSONString(nums));
                System.out.println(JSONObject.toJSONString(num));
            }
            h = (h - 1) / 3;
            System.out.println("hhhhhhhhhhh = " + h);
        }
    }


    public static void shell3(int[] nums) {
        int inner, outer, temp, h = 1;
        while (h < nums.length / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for(outer = h; outer < nums.length; outer++) {
                inner = outer;
                temp = nums[outer];
                while (inner > h - 1 && nums[inner - h] > temp) {
                    nums[inner] = nums[inner - h];
                    inner -= h;
                }
                nums[inner]  = temp;
            }
            h = (h - 1)/3;
        }
    }
}
