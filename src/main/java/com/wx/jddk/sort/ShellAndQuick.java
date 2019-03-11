package com.wx.jddk.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author weixing
 * @date 2019/3/10
 **/
public class ShellAndQuick {

    public static void main(String[] args) {
        int[] nums = {5, 6, 2, 1, 2, 6, 3, 9, 7, 1, 5, 8};
//        shell(nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.println(JSONObject.toJSONString(nums));
    }

    public static void shell(int[] nums) {
        int inner, outer, temp, h = 1;
        while (h < nums.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < nums.length; outer++) {
                inner = outer;
                temp = nums[outer];
                while (inner > h - 1 && nums[inner - h] > temp) {
                    nums[inner] = nums[inner - h];
                    inner -= h;
                }
                nums[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (nums[leftPtr] < pivot) {
                leftPtr++;
            }
            while (rightPtr > 0 && nums[rightPtr] > pivot) {
                rightPtr--;
            }
            if (leftPtr >= rightPtr) {
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
