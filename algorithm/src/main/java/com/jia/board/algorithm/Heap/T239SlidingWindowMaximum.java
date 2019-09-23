package com.jia.board.algorithm.Heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 存在一个数组，然后有一个滑动窗口沿着数组一个个向后移动，求每次滑动窗口中的最大值
 *
 * 使用双端队列，队列的第一位永远保持为最大值
 */

public class T239SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0){
            return new int[0];
        }

        int[] result = new int[nums.length-k+1];
        int resInd = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i<nums.length; i++){
            if (i>=k && deque.peek()<=i-k){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offer(i);    // 在这种情况下，push是插入第一位，offer是插入最后一位
            if (i >= k-1){
                result[resInd++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static int[] maxSlidingWindow1(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];      // 长度为0的数组
        }
        int n = a.length;
        int[] r = new int[n-k+1];   // 结果存放数组
        int ri = 0;                 // 结果数组索引号
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int a : res){
            System.out.println(a);
        }
    }
}
