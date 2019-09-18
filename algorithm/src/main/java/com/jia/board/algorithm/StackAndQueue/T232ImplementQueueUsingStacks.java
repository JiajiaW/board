package com.jia.board.algorithm.StackAndQueue;

import java.util.Stack;

/**
 * 使用栈实现队列，只能使用最原始的操作，后进先出，查看最后一个元素，判断是否为空
 */
public class T232ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(5);
        obj.push(6);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

/**
 * push直接放进s1
 * pop/peek 先判断s2有没有，s2有的话直接pop/peek，不要倒腾，不然顺序就错误了；
 *               s2没有的话倒腾过去
 */
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    // 可以复用peek的函数
    // int res = peek(); return s2.pop();
    public int pop() {
        if (! s2.empty()){
            return s2.pop();
        }
        while (! s1.empty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (! s2.empty()){
            return s2.peek();
        }
        while (! s1.empty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (s1.empty() && s2.empty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
