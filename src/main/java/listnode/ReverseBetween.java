package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        //先找出需要反转的链表
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        // 1->2->3->4->5->NULL, m = 2, n = 4
        // 1->3->2->4->5->NULL
        // pre = 1, cur = 2, next = 3
        for (int i = 0; i < n - m; i++) {
            // 这里反转 2 和 3
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = new ListNode(1);
        ListNode index = head;
        for (int i = 2; i <= 5; i++) {
            index.next = new ListNode(i);
            index = index.next;
        }
        ListNode res = reverseBetween.reverseBetween(head, 2, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
