package com.wx.jddk.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author weixing
 * @date 2019/3/9
 **/
public class Quick {

    public static void main(String[] args) {
        int[] nums = {5, 6, 2, 1, 2, 6, 3, 9, 7, 1, 5, 8};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(JSONObject.toJSONString(nums));
    }


    public static void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        } else {
            return;
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int leftPtr = left, rightPtr = right - 1;
        while (true) {
            while (nums[leftPtr] < pivot) {
                leftPtr++;
            }
            while (rightPtr > 0 && nums[rightPtr] > pivot) {
                rightPtr--;
            }
            if(leftPtr >= rightPtr) {
                break;
            } else {
                swap(nums, leftPtr, rightPtr);
            }
        }
        swap(nums, leftPtr, right);
        return leftPtr;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
