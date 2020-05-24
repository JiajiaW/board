package com.jia.board.algorithm;

public class T153FindRotateNum {

    public static int findRotateNum(int[] a){

        if (a == null || a.length < 1){
            return -1;
        }

        if (a.length == 1) {
            return a[0];
        }

        int low = 0;
        int high = a.length-1;

        // 存在没有旋转的情况
        if (a[high] > a[0]){
            return a[0];
        }

        while (low <= high){
            int mid = low + (high - low)/2;
            if (mid > 0 && a[mid-1] > a[mid]){
                return a[mid];
            }
            if (mid < a.length-1 && a[mid] > a[mid+1]){
                return a[mid+1];
            }
            if (a[mid] > a[0]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                // middle可能是最小值
                right = middle;
            } else {
                // middle肯定不是最小值
                left = middle + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

        int[] a = new int[]{3, 4, 5, 1, 2};
        System.out.println(findRotateNum(a));
    }
}
