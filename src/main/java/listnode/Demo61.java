package listnode;

import top20.ListNode;

import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode len = head;
        int length = 0;
        while (len != null) {
            length++;
            len = len.next;
        }


        k = k % length;
        if(k == 0) return head;
        ListNode root = reverse(head);

        ListNode pre = root;
        ListNode preIndex = pre;
        ListNode next;

        while (k > 1) {
            pre = pre.next;
            k--;
        }
        next = pre.next;
        pre.next = null;
        next = reverse(next);
        preIndex = reverse(preIndex);
        ListNode res = new ListNode(0);
        res.next = preIndex;
        ListNode cur = res;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = next;
        return res.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        Demo61 demo61 = new Demo61();
        demo61.rotateRight(l1, 2);
    }
}
