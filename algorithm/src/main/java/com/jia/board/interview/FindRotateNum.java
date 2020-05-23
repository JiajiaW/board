package com.jia.board.interview;

public class FindRotateNum {

    public static int findRotateNum(int[] a){

        if (a == null || a.length < 1){
            return -1;
        }

        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (mid > 0 && a[mid-1] > a[mid]){
                return mid;
            }
            if (mid < a.length-1 && a[mid] > a[mid+1]){
                return mid+1;
            }
            if (a[mid] > a[low]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = new int[]{3, 4, 5, 1, 2};
        System.out.println(findRotateNum(a));
    }
}
