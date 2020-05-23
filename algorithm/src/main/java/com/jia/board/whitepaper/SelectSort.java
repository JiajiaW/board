package com.jia.board.whitepaper;

public class SelectSort {

    public static void selectSort(int[] a){

        if (a == null || a.length <= 1){
            return;
        }

        for (int i=0; i<a.length-1; i++){
            int maxVal = 0;
            for (int j=1; j<a.length-i; j++){
                if (a[j] > a[maxVal]){
                    maxVal = j;
                }
            }
            swap(a, maxVal, a.length-i-1);
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
        selectSort(a);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
