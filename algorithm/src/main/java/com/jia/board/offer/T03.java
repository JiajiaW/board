package com.jia.board.offer;

import java.util.HashSet;
import java.util.Set;

public class T03 {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 如果当前的数 nums[i] 没有在下标为 i 的位置上，就把它交换到下标 i 上
            // 交换过来的数还得做相同的操作，因此这里使用 while
            // 可以在此处将数组输出打印，观察程序运行流程
            // System.out.println(Arrays.toString(nums));

            while (nums[i] != i) {

                if (nums[i] == nums[nums[i]]) {
                    // 如果下标为 nums[i] 的数值 nums[nums[i]] 它们二者相等
                    // 正好找到了重复的元素，将它返回
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        throw new IllegalArgumentException("数组中不存在重复数字！");
    }


    public int findRepeatNumber1(int[] nums) {
        boolean[] table = new boolean[100001];
        for(int num : nums){
            if(table[num]){
                return num;
            }else{
                table[num] = true;
            }
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
