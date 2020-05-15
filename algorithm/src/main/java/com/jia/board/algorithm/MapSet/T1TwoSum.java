package com.jia.board.algorithm.MapSet;

import java.util.HashMap;
import java.util.Map;

public class T1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int another = target-nums[i];
            if (map.containsKey(another)){
                return new int[]{map.get(another), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // 看看和别人程序的对比
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(a, target);
        for (int tmp : res){
            System.out.println(tmp);
        }
    }
}
