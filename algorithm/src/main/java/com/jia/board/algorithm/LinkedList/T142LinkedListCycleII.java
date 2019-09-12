package com.jia.board.algorithm.LinkedList;

/**
 * 判断是否有环，并找出环开始的地方
 * 1. 使用set 判重，重复的即环开始的地方
 * 2. 快慢指针
 *
 * （一）
 * 首先要证明的是，两指针相遇时，慢指针还没有走完整个链表。
 * （1）如果慢指针第一次达到Join点时，快指针也在Join点，慢指针自然没有走完整个链表；
 * （2）如果慢指针第一次达到Join点时，快指针没有在Join点，我们以最极端的情况来说，假设快指针这时就在慢指针的前面一个节点，
 *     这时，快指针追上慢指针需要走最长的距离。因为快指针的速度是慢指针的两倍，所以慢指针走一圈，快指针走两圈，当慢指针第
 *     一次在环上走完一圈回到Join点时，快指针刚好走完两圈，并且已经在慢指针的前面，所以它两在慢指针第一次回到Join点之前就
 *     已经相遇。
 * 最终，得出结论：两指针相遇时，慢指针还没有走完整个链表。
 * （二）
 * 然后，我们来证明，快慢指针相遇后，慢指针再往前移LenA个节点就刚好到达Join点。
 * 假设第一次相遇点为Pos，环起点为Join，头结点到环起点的长度为LenA，环起点到第一次相遇点的长度为x，
 * 第一次相遇点到环起点的长度为y，环长为R，于是有以下结果：
 * （1）第一次相遇时，slow走的长度 S = LenA + x;（由证明的第一部分得到）
 * （2）第一次相遇时，fast走的长度 2S = LenA + n*R + x;（相遇时，快指针可能已经绕环好几圈了；至少一圈，n大于等于1，因为快指针先进入环，
 *     要追上后进入的慢指针，必须得回到环起点在起点之后才能追上）
 * （3）LenA + x = n*R; LenA = n*R -x;
 * 其中，（3）是由（1）（2）推导出来的。
 * 我们的目标是根据上面三点得出慢指针在走了S + LenA后刚好到达Join点（这是清晰说明这个问题的关键）。我们尝试根据上面三点推导出我们想要的结论：
 * S + LenA = S + n*R - x = S + (n - 1)*R + (R - x) = S + (n - 1)*R + y
 * 这个表达式证明了我们的结论：慢指针在移动S + (n - 1)*R个节点后刚好在快慢指针第一次相遇的位置，再移动y个节点后就刚好达到Join点。
 */
public class T142LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean tag = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                tag = true;
                break;
            }
        }

        if (!tag){
            return null;
        }

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 和上个方法类似，就是将第二部分挪到第一部分写了
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
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
        ListNode result = detectCycle(node1);
        System.out.println(result.val);
    }
}
