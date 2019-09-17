package com.jia.board.algorithm.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class T225ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(4);
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

/**
 * 在查看元素时倒腾到剩一个元素，然后pop或者peek，之后再倒腾回来。感觉这种做法好傻。。
 */
class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1){
            q2.add(q1.remove());
        }
        int res = q1.remove();

        while (!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        int res = 0;
        while (!q1.isEmpty()){
            res = q1.remove();
            q2.add(res);
        }

        while (!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return res;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
