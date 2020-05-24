package com.jia.board.offer;

public class T05 {

    public String replaceSpace(String s) {
        // 计算空格的个数，或者可以直接多声明的大一点
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        // 申请大小合适的数组进行替换
        char[] tmp = new char[s.length() + 2 * count];
        int index = 0;
        for (
                int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                tmp[index++] = '%';
                tmp[index++] = '2';
                tmp[index++] = '0';
            } else {
                tmp[index++] = s.charAt(i);
            }
        }
        return String.valueOf(tmp);
    }
}
