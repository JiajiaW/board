package com.jia.board.algorithm;

import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * @author wanjia
 */
public class T239MaxSlidingWindow {

    /**
     * 暴力方法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                maxValue = Math.max(nums[i + j], maxValue);
            }
            res[i] = maxValue;
        }
        return res;
    }

    /**
     * 使用双端队列
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }

        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]) {
                qMax.pollLast();
            }

            qMax.addLast(i);

            if (qMax.peekFirst() == (i - k)) {
                qMax.pollFirst();
            }

            if (i >= (k - 1)) {
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] a = new int[]{1,3,1,2,0,5};
        int[] res = maxSlidingWindow1(a, 3);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
