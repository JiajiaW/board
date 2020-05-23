package com.jia.board.whitepaper;

public class InsertSort {

    public static void insertSort(int[] a) {

        if (a == null || a.length <= 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j = i;
            for (j = i; j > 0; j--) {
                if (a[j - 1] > val) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = val;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,7,2,6,8,2,5,8};
        insertSort(a);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
