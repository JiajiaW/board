package com.jia.board.algorithm.Heap;

import java.util.Arrays;

/**
 *
 */

/**
 * 嗯，这种排序选取k大的元素感觉要考虑的因素还是很多呀，像我就没有考虑数组为空的情况
 * 明天加油！
 */
class KthLargest {

    int[] kNums;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        kNums = new int[k+1];
        Arrays.sort(nums);
        int i=nums.length-1;
        for (int j = k; j>=0; j--){
            if (i<0){
                break;
            }
            kNums[j] = nums[i];
            i--;
        }
    }

    public int add(int val) {
        if (val < kNums[1]){
            return kNums[1];
        }
        else {
            kNums[0] = val;
            Arrays.sort(kNums);
            return kNums[1];
        }
    }

}


public class T703KthLargestElementInAStream {

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{4,5,8,2};
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));   // returns 4
        System.out.println(obj.add(5));   // returns 5
        System.out.println(obj.add(10));  // returns 5
        System.out.println(obj.add(9));   // returns 8
        System.out.println(obj.add(4));   // returns 8

    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
