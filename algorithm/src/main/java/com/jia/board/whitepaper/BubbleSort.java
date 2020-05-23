package com.jia.board.whitepaper;

public class BubbleSort {

    public static void bubbleSort(int[] a){

        if (a == null || a.length <= 1){
            return;
        }

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
        bubbleSort(a);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
