package com.jia.board.algorithm.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 * 1. 硬做，超时时间内循环
 * 2. 使用set 判重
 * 3. 快慢指针   使用归纳总结证明 步数相差为1，2，n
 */

public class T141LinkedListCycle {

    // 快慢指针
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    // set 方法
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        boolean result = hasCycle(node1);
        System.out.println(result);
    }
}
