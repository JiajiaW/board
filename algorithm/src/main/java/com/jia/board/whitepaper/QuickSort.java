package com.jia.board.whitepaper;

public class QuickSort {

    public static void quickSort(int[] a){

        if (a == null || a.length <= 1){
            return;
        }
        quickSortInternally(a, 0, a.length-1);
    }

    private static void quickSortInternally(int[] a, int p, int r){

        if (p >= r){
            return;
        }

        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r){
        int pivot = a[r];
        int i = p;
        int j = p;
        for (j=p; j<r; j++){
            if (a[j] < pivot){
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
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
        int[] a = new int[]{5, 6, 8, 4, 3, 2, 6};
        quickSort(a);

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
