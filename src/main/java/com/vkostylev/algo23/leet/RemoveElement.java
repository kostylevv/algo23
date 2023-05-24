package com.vkostylev.algo23.leet;

import java.util.Arrays;

/**
 * Solving remove element programming challenge from Leetcode
 * See https://leetcode.com/problems/remove-element/?envType=study-plan-v2&id=top-interview-150
 */

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = {2,3,3};
        System.out.println(removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1));
        //removeElement(nums1, 3);
    }

    public static int removeElement(int[] nums, int val) {
        int lastIndex = nums.length-1;
        for (int i = 0; i <= lastIndex; i++) {
            if (nums[i] == val) {
                lastIndex = replace(nums, i, lastIndex, val);
                if (lastIndex == -1) return i;
            }
        }
        return lastIndex+1;
    }

    private static int replace(int[] nums, int foundIndex, int lastIndex, int toRemove) {
        if (foundIndex == lastIndex) return -1;
        for (int i = lastIndex; i > foundIndex; i--) {
            if (nums[i] != toRemove) {
                nums[foundIndex] = nums[i];
                nums[i] = toRemove;
                return --lastIndex;
            }
        }
        return -1;
    }
}
