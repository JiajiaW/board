package com.jia.board.geek.sort;

public class InsertSort {

    public static void insertSort(int[] a){

        for (int i=1; i<a.length; i++){

            int value = a[i];
            int j = i-1;

            for (j=i-1; j>=0; j--){
                if (a[j] > value){
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void main(String[] args){

        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6, 4};
        insertSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
