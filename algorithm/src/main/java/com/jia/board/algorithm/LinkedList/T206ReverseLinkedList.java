package com.jia.board.algorithm.LinkedList;


public class T206ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 头插法
    public static ListNode reverseList1(ListNode head) {

        ListNode result = new ListNode(-1);
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = result.next;
            result.next=cur;
            cur = next;
        }

        return result.next;
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
        ListNode newList = reverseList(node1);
        while (newList != null){
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
