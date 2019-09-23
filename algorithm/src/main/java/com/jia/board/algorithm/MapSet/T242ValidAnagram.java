package com.jia.board.algorithm.MapSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求两个字符串中所含的字符是否是一样的
 */
public class T242ValidAnagram {

    // 排序元素，然后比较
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    // 题目中说只有小写字母，所以声明一个26位的数组即可
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        return map1.equals(map2);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean res = isAnagram(s, t);
        System.out.println(res);

    }
}
