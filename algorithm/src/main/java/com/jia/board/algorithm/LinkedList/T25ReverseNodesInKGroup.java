package com.jia.board.algorithm.LinkedList;

/**
 * k个一组翻转链表，如果不足k个元素则保持原样
 * 不要改变节点的值，使用常量空间
 * k为正整数，并且小于等于链表长度
 *
 * 切记每次反转后保存反转后的最后一个元素，即反转前的第一个元素，即下面程序中的tmp
 */
public class T25ReverseNodesInKGroup {

    // 先判断是否有k个元素，然后翻转链表
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);  // 声明头指针，方便统一操作
        dummy.next = head;

        ListNode next = dummy.next;    // 指向未反转的第一个元素 (在判断K个元素之后)
        ListNode pre = dummy;          // 指向反转后的最后一个元素 （未进行反转之前dummy相当于反转后的最后一个元素）

        // 为反转链表声明参数
        ListNode curPre;
        ListNode cur = head;
        ListNode curNext;

        while (cur != null){
            // 判断是否有k个元素
            for (int i=0; i<k; i++){
                if (next == null){
                    return dummy.next;
                }
                next = next.next;
            }

            // 没有K个元素的已经返回了，处理存在k个元素的情况
            ListNode tmp = cur;  // 为了保留反转后的最后一个元素，即反转前的第一个元素
            curPre = next;       // 反转后的最后一个元素应该指向next
            while (cur != next){
                curNext = cur.next;
                cur.next = curPre;
                curPre = cur;
                cur = curNext;
            }

            pre.next = curPre;
            pre = tmp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode newList = reverseKGroup(node1, 3);
        while (newList != null){
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
