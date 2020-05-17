package com.jia.board.algorithm;

public class T69MySqrt {

    public static int mySqrt(int x){

        int low = 0;
        int high = x;

        while (low <= high){
            int mid = low + ((high - low)>>1);
            long value = 1L * mid * mid;
            if (value == x){
                return mid;
            } else if (value > x){
                high = mid - 1;
            } else {
                if (1L*(mid+1)*(mid+1) > x){
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(2147483647));
    }
}
