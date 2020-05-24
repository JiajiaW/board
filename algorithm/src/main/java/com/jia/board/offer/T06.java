package com.jia.board.offer;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class T06 {

    public int[] reversePrint(ListNode head) {

        // 先翻转链表
        ListNode newHead = reverseList(head);
        // 确定个数，不然不好声明数组
        ListNode cur = newHead;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int[] res = new int[count];
        count = 0;
        cur = newHead;
        while (cur != null) {
            res[count++] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static int[] reversePrint1(ListNode head) {
        // 使用栈
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        // 输出结果
        int count = stack.size();
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    /**
     * 递归使用
     *
     * @param head
     * @return
     */
    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public int[] reversePrint2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);

        a.next = b;
        b.next = c;

        reversePrint1(a);
    }
}
