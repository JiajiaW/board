package com.jia.board.geek.sort;

public class MergeSort {

    public static void mergeSort(int[] a, int n) {

        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {

        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 分治递归
        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 合并
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {

        int[] tmp = new int[r - p + 1];
        int count = 0;

        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[count++] = a[i++];
            } else {
                tmp[count++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据，这种方式比判断两次巧妙些
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[count++] = a[start++];
        }

        // 将tmp中的数据拷贝回a[p...r]
        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6};
        mergeSort(a, a.length);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
