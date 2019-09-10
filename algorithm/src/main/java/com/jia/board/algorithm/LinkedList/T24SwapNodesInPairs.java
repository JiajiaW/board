package com.jia.board.algorithm.LinkedList;

public class T24SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode cur = head;
        ListNode next;
        while (cur!=null && cur.next!=null){
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return result.next;
    }

    // 递归方法
    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }

    // discussion vote 解法，比我的更精简
    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;   // 指向了两个要交换节点的后面节点
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
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
        ListNode newList = swapPairs(node1);
        while (newList != null){
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
