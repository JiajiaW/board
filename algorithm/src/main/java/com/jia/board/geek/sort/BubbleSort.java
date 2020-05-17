package com.jia.board.geek.sort;

public class BubbleSort {

    public static void swap(int[] arr, int i, int maxPos){
        int tmp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = tmp;
    }

    public static void bubbleSort(int[] a){

        for (int i=0; i<a.length-1; i++){
            boolean flag = true;
            for (int j=0; j<a.length-1-i; j++){
                if (a[j] > a[j+1]){
                    swap(a, j, j+1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6, 4};
        bubbleSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
