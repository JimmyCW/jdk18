package com.wx.jddk.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author weixing
 * @date 2019/3/9
 **/
public class Bubble {

    public static void main(String[] args) {
        int[] nums = {5,3,2,1,6,5,3,4};
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(JSONObject.toJSONString(nums));

    }
}
