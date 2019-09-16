package com.jia.board.algorithm.LinkedList;

/**
 * k个一组翻转链表，如果不足k个元素则保持原样
 * 不要改变节点的值，使用常量空间
 * k为正整数，并且小于等于链表长度
 */
public class T25ReverseNodesInKGroup {

    // 先判断是否有k个元素，然后翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode curK = dummy.next;

        // 判断是否有k个元素
        for (int i=0; i<k; i++){
            if (curK == null){
                return dummy.next;
            }
            curK = curK.next;
        }

        // 没有K个元素的已经返回了，处理存在k个元素的情况

    }
}
