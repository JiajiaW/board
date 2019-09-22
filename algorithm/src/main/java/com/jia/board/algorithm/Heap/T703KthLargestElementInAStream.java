package com.jia.board.algorithm.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 流式数据获取第K大元素
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

/**
 * 模仿下面的写的，还需继续改进
 */
class KthLargest1 {

    private PriorityQueue<Integer> p = new PriorityQueue<>();
    private int k;

    public KthLargest1(int k, int[] nums) {
        this.k = k;

        for (int num : nums){
            if (p.size() < k){
                p.add(num);
            }
            else if (p.peek() < num){
                p.remove();
                p.add(num);
            }
        }
    }

    public int add(int val) {
        if (p.size() < k){
            p.add(val);
            return p.peek();
        }
        if (val < p.peek()) {
            return p.peek();
        }
        else {
          p.remove();
          p.add(val);
          return p.peek();
        }
    }
}

/**
 * 投票高的写法，写的比我简洁
 */
class KthLargest2 {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest2(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}


public class T703KthLargestElementInAStream {

    public static void main(String[] args) {
        int k = 1;
        //int[] nums = new int[]{4,5,8,2};
        int[] nums = new int[]{};
        KthLargest1 obj = new KthLargest1(k, nums);
        System.out.println(obj.add(3));   // returns 4
        System.out.println(obj.add(5));   // returns 5
        System.out.println(obj.add(10));  // returns 5
        System.out.println(obj.add(9));   // returns 8
        System.out.println(obj.add(4));   // returns 8

        PriorityQueue<Integer> test = new PriorityQueue<>();
        test.add(3);
        test.add(6);
        test.add(5);
        System.out.println(test.peek());

    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
