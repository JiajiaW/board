package com.jia.board.interview;

public class RevertPartStr {

    public static String revertPartStr(String str){

        if (str == null || str.length() <= 2){
            return str;
        }

        int n = str.length();
        int mid = n / 2;
        char[] tmp = new char[n];
        int index = 0;

        for (int i=0; i<mid; i++){
            tmp[index++] = str.charAt(i);
        }
        for (int i=n-1; i>=mid; i--){
            tmp[index++] = str.charAt(i);
        }
        return String.valueOf(tmp);
    }

    public static void main(String[] args) {

        String str = "ab";
        System.out.println(revertPartStr(str));
    }
}
