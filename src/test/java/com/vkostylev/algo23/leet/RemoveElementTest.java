package com.vkostylev.algo23.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveElementTest {

    @Test
    void checkExample2 () {
        int[] nums1 = {0,1,2,2,3,0,4,2};
        int result = RemoveElement.removeElement(nums1,2);
        Assertions.assertTrue(result==5);
    }

    @Test
    void checkExample1 () {
        int[] nums1 = {3,2,2,3};
        int result = RemoveElement.removeElement(nums1,3);
        Assertions.assertTrue(result==2);
    }

    @Test
    void checkExample3 () {
        int[] nums1 = {3,3};
        int result = RemoveElement.removeElement(nums1,3);
        Assertions.assertTrue(result==0);
    }

    @Test
    void checkExample4 () {
        int[] nums1 = {3,2};
        int result = RemoveElement.removeElement(nums1,3);
        Assertions.assertEquals(1, result);
    }

    @Test
    void checkExample5 () {
        int[] nums1 = {3,2};
        int result = RemoveElement.removeElement(nums1,2);
        Assertions.assertTrue(result==1);
    }

    @Test
    void checkExample6 () {
        int[] nums1 = {};
        int result = RemoveElement.removeElement(nums1,0);
        Assertions.assertTrue(result==0);
    }

    @Test
    void checkExample7 () {
        int[] nums1 = {2,3,3};
        int result = RemoveElement.removeElement(nums1,3);
        Assertions.assertTrue(result==1);
    }
}
