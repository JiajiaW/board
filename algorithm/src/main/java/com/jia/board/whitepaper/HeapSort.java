package com.jia.board.whitepaper;

public class HeapSort {

    public static void heapSort(int[] a){

        if (a == null || a.length <= 1){
            return;
        }

        int n = a.length;

        // 建堆
        buildHeap(a, n);

        // 排序
        swap(a, 0, n-1);
        for (int i=n-2; i>0; i--){
            heapify(a, 0, i);
            swap(a, 0, i);
        }
    }

    private static void buildHeap(int[] a, int n) {

        // 从第一个非叶子节点开始调整，直至调整到根节点
        for (int i=(n-2)/2; i>=0; i--){
            heapify(a, i, n-1);
        }
    }

    private static void heapify(int[] a, int i, int n) {

        int maxPos = i;
        int index = i;
        while (maxPos <= n){
            if (2*index+1 <= n && a[2*index+1]<a[maxPos]){
                maxPos = 2*index + 1;
            }
            if (2*index+2 <= n && a[2*index+2]<a[maxPos]){
                maxPos = 2*index + 2;
            }
            if (index == maxPos){
                break;
            }
            swap(a, index, maxPos);
            index = maxPos;
        }
    }

    public static void swap(int[] a, int i, int j){
        if (i==j){
            return;
        }
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,7,2,6,8,2,5,8};
        heapSort(a);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
