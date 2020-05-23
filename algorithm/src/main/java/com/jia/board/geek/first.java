package com.jia.board.geek;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组 1 2 3 4 5
 * 返回其中k 比如k=2
 * 连续k个元素的值最大
 * 数组不一定有序
 */
public class first {

    public static int getKMax(int[] a, int k){

        if (a.length < k){
            return -1;
        }

        int maxValue = 0;
        int index = 0;
        int sum = 0;

        for (int i=0; i<k; i++){
            sum += a[i];
        }
        maxValue = sum;

        for (int i=k; i<a.length; i++){

            sum -= a[index++];
            sum += a[i];

            if (sum > maxValue){
                maxValue = sum;
            }

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(getKMax(a, 2));

        // 错误的写法
//        Map<String, Integer> map = new HashMap<>();
//        map.put("1", 10);
//        map.put("2", 20);
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()){
//            if (entry.getKey() == "1"){
//                map.remove(entry.getKey());
//            }
//        }
    }
}
