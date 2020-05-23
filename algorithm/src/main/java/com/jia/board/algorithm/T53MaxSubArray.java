package com.jia.board.algorithm;

/**
 * 最大子序列和
 * @author wanjia
 */
public class T53MaxSubArray {

    public static int maxSubArray(int[] nums){

        if (nums.length < 1){
            return -1;
        }

        int maxValue = nums[0];
        int sum = nums[0];

        for (int i=1; i<nums.length; i++){

            if (sum+nums[i] <= nums[i]){
                sum = nums[i];
            }else {
                sum += nums[i];
            }

            maxValue = Math.max(sum, maxValue);
        }

        return maxValue;
    }

    public static void main(String[] args) {

        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));

    }
}
