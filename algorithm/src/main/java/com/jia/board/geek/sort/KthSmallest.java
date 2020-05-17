package com.jia.board.geek.sort;

/**
 * 感觉这个方法写的并不好，在每次partition的时候，都得重新要么从0到q，要么从q到长度
 *
 * todo: 有时间重新想想怎么做
 */
public class KthSmallest {

    public static int kthSmallest(int[] a, int k){

        if (a == null || a.length < k){
            return -1;
        }

        int partition = partition(a, 0, a.length-1);
        while (partition + 1 != k){
            if (partition+1 < k){
                partition = partition(a, partition+1, a.length-1);
            }else if (partition+1 > k){
                partition = partition(a, 0, partition-1);
            }
        }

        return a[partition];

    }


    public static int partition(int[] a, int p, int r){

        int pivot = a[r];
        int i = p;
        for (int j=p; j<r; j++){
            // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
            if (a[j] <= pivot){
                swap(a, j, i);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    public static void swap(int[] arr, int i, int j){

        if (i == j){
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6, 4};
        System.out.println(kthSmallest(a, 4));

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
