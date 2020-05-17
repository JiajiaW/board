package com.jia.board.geek.sort;

/**
 * 主要目的在于练习一遍
 * @author wanjia
 */
public class HeapSort1 {

    public static void heapSort(int[] a){

        // 如果只有一个元素，直接退出
        if (a.length <= 1){
            return;
        }

        // 建堆
        buildHeap(a);

        // 排序
        int k = a.length - 1;
        for (int i=k; i>0; i--){
            swap(a, i, 0);
            heapify(a, i-1, 0);
        }

    }

    /**
     * 建堆
     * 从最后一个非叶子节点开始
     * @param a
     */
    public static void buildHeap(int[] a){
        for (int i = (a.length-2)/2; i>=0; i--){
            heapify(a, a.length-1, i);
        }
    }

    public static void heapify(int[] a, int n, int i){
        int maxPos = i;
        while (true){
            if (i * 2 + 1 <= n && a[i*2+1] > a[i]){
                maxPos = i*2+1;
            }
            if (i * 2 + 2 <= n && a[i*2+2] > a[maxPos]){
                maxPos = i*2+2;
            }

            if (maxPos == i){
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }

    }

    public static void swap(int[] arr, int i, int maxPos){
        int tmp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = tmp;
    }

    public static void main(String[] args){
        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6, 4};
        heapSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
