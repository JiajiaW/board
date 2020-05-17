package com.jia.board.geek.binarysearch;

public class BinarySearch {

    /**
     * 循环实现的二分查找
     * @param a
     * @param m
     * @return
     */
    public static int binarySearch(int[] a, int m){

        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (a[mid] == m){
                return mid;
            } else if (a[mid] > m){
                high = mid - 1;
            } else if (a[mid] < m){
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现的二分查找
     * @param a
     * @param m
     * @return
     */
    public static int binarySearch1(int[] a, int m){

        return bsearchInternally(a, 0, a.length-1, m);
    }

    public static int bsearchInternally(int[] a, int low, int high, int value){

        if (high > low){
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value){
            return mid;
        }else if (a[mid] > value){
            return bsearchInternally(a, low, mid-1, value);
        } else {
            return bsearchInternally(a, mid+1, high, value);
        }
    }

    public static void main(String[] args){

        int[] a = new int[]{2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(a, 4));

        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
