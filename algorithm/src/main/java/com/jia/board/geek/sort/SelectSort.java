package com.jia.board.geek.sort;

public class SelectSort {

    public static void swap(int[] arr, int i, int maxPos){
        int tmp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = tmp;
    }

    public static void selectSort(int[] a){

        for (int i=0; i<a.length-1; i++){
            int minIndex = i;
            for (int j=i+1; j<a.length; j++){
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6, 4};
        selectSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
