package com.jia.board.whitepaper;

public class MergeSort {

    public static void mergeSort(int[] a){

        if (a == null || a.length <= 1){
            return;
        }
        mergeSortInternally(a, 0, a.length-1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {

        if (p == r){
            return;
        }

        int q = p + (r - p)/2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {

        int[] tmp = new int[r-p+1];
        int i = p;
        int j = q+1;
        int index = 0;
        while (i <= q && j <= r){
            if (a[i] <= a[j]){
                tmp[index++] = a[i++];
            }else {
                tmp[index++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r){
            start = j;
            end = r;
        }
        while (start <= end){
            tmp[index] = a[start++];
        }

        for (int k=0; k<tmp.length; k++){
            a[p++] = tmp[k];
        }
    }


    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6};
        mergeSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
