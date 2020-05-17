package com.jia.board.geek.sort;


public class HeapSort {

    /**
     * 我先写的一版，错误挺多，看看别人写的。
     * @param a
     */
    public static void heapSort1(int[] a){

        int n = a.length;

        // 建立大顶堆
        for (int i=(n-2)/2; i>=0; i--){
            int index = i;
            while ((index*2+1) < n) {
                int k = index;
                int value = a[k];
                if (a[k * 2 + 1] >= a[k * 2 + 2]) {
                    index = k * 2 + 1;
                } else {
                    index = k * 2 + 2;
                }

                if (a[k] < a[index]) {
                    a[k] = a[index];
                    a[index] = value;
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int maxPos){
        int tmp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = tmp;
    }


    public static void heapSort(int[] a){
        if (a.length <= 1){
            return;
        }

        // 1. 建堆
        buildHeap(a);

        // 2. 排序
        int k = a.length - 1;
        while (k > 0){
            swap(a, 0, k);
            heapify(a, --k, 0);
        }
    }

    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点  注意：这个随便举个例子就知道不对了，应该是索引所在的数值 (index-1)/2
        // 最后一个叶子节点的父节点 也就是最后一个非叶子节点 索引应该为(arr.length-1-1)/2
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    /**
     * 堆化
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }


    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6, 4};
        heapSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
