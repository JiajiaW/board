package com.jia.board.algorithm.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断大中小括号是否配对
 */
public class T20ValidParentheses {

    // 自己写的，判定条件那写的不优美
    public static boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : sArray){
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else if (!((c==')' && !stack.empty() && '('==stack.pop())
                || (c==']' && !stack.empty() && '['==stack.pop())
                || (c=='}' && !stack.empty() && '{'==stack.pop()))){
                return false;
            }
        }

        // 下面可改写为 return stack.empty()
        if (stack.empty()){
            return true;
        }
        else {
            return false;
        }
    }


    public static boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (! map.containsKey(c)){
                stack.push(c);
            }
            else if (stack.empty() || map.get(c) != stack.pop()){
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        boolean res = isValid1("([])");
        System.out.println(res);
    }
}
