package com.jia.board.algorithm.StackAndQueue;

import java.util.Stack;

/**
 * 给两个字符串，有#（相当于删除前面的字符），判断两个字符串是否相等
 *
 * 注意点：pop之前判断是否为空，不然很容易报错
 */
public class T844BackspaceStringCompare {

    // 声明两个栈，先求去掉#之后的原始字符串，然后在pop的时候进行比较
    public static boolean backspaceCompare(String S, String T) {
        char[] sArray = S.toCharArray();
        char[] tArray = T.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i=0; i<S.length(); i++){
            if (sArray[i] != '#'){
                stack1.push(sArray[i]);
            }
            else if (!stack1.isEmpty()){
                stack1.pop();
            }
        }

        for (int i=0; i<T.length(); i++){
            if (tArray[i] != '#'){
                stack2.push(tArray[i]);
            }
            else  if (!stack2.isEmpty()){
                stack2.pop();
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.pop() != stack2.pop()){
                return false;
            }
        }

        if (!stack1.isEmpty() || !stack2.isEmpty()){
            return false;
        }

        return true;
    }

    // 和上面同一种思路
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }


    // 从后面开始遍历，遇到有#的向前挪动相应字符的个数。
    // 每次比较当前字符是否相当，并且注意一个字符串已经遍历完毕而另一个字符串还有别的字符
    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }


    public static void main(String[] args) {
        boolean result = backspaceCompare("a##c", "#a#c");
        System.out.println(result);
    }
}
