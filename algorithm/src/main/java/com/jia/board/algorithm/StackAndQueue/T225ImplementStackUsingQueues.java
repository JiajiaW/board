package com.jia.board.algorithm.StackAndQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈，只能使用队列最基本的操作，后进先出，查看第一个元素，判断是否为空
 */
public class T225ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack1 obj = new MyStack1();
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
 * 每次判断哪个队列是否为空，相比于上个方法不用倒腾两次，但是代码写得比较冗余
 */
class MyStack1 {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack1() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!q1.isEmpty()){
            q1.add(x);
        }
        else {
            q2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (! q1.isEmpty()){
            while (q1.size() > 1){
                q2.add(q1.remove());
            }
            return q1.remove();
        }

        else if (! q2.isEmpty()) {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            return q2.remove();
        }

        return 0;
    }


    /** Get the top element. */
    public int top() {
        int res;
        if (! q1.isEmpty()){
            while (q1.size() > 1){
                q2.add(q1.remove());
            }
            res = q1.peek();
            q2.add(q1.remove());
            return res;
        }
        else if (! q2.isEmpty()){
            while (q2.size() > 1){
                q1.add(q2.remove());
            }
            res = q2.peek();
            q1.add(q2.remove());
            return res;
        }

        return 0;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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
