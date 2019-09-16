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

    public static void main(String[] args) {
        boolean result = backspaceCompare("a##c", "#a#c");
        System.out.println(result);
    }
}
