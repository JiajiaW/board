package com.jia.board.algorithm.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 * 1. 硬做，超时时间内循环
 * 2. 使用set 判重
 * 3. 快慢指针   使用归纳总结证明 步数相差为1，2，n.  至于其余的步数差和环长度之间决定是否相遇的不做了解
 *
 * 如果链表没有环，那么快指针比慢指针先到达尾部（null)。
 * 如果链表有环的话，因为快指针走的比慢指针快，所以在环中相遇的过程可以看作是快指针从环后边追赶慢指针的过程。
 * 用递归法证明，快慢指针一定会相遇：
 * 快指针与慢指针之间差一步。此时继续往后走，慢指针前进一步，快指针前进两步，两者相遇。
 * 快指针与慢指针之间差两步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差一步，转化为第一种情况。
 * 快指针与慢指针之间差 [公式] 步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差 [公式] 即 [公式] 步。重复这个过程，直到快指针和慢指针相遇。
 * 因此，此题得证。所以快指针必然与慢指针相遇。
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
