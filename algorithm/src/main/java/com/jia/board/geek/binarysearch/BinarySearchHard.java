package com.jia.board.geek.binarysearch;

public class BinarySearchHard {

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch(int[] a, int value){

        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (a[mid] > value){
                high = mid - 1;
            }
            if (a[mid] < value){
                low = mid + 1;
            }
            if (a[mid] == value){
                if (mid > 0 && a[mid-1] == value){
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch1(int[] a, int value){

        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (a[mid] > value){
                high = mid - 1;
            }
            if (a[mid] < value){
                low = mid + 1;
            }
            if (a[mid] == value){
                if (mid == a.length-1 || a[mid+1] != value){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch2(int[] a, int value){

        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (a[mid] >= value){
                if (mid == 0 || a[mid-1] < value){
                    return mid;
                }
                high = mid - 1;
            }
            if (a[mid] < value){
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch3(int[] a, int value){

        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (a[mid] > value){
                high = mid - 1;
            }
            if (a[mid] <= value){
                if (mid == a.length-1 || a[mid+1] > value){
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] a = new int[]{4, 4, 4, 4, 6, 7};
        System.out.println(binarySearch2(a, 4));
    }


}
