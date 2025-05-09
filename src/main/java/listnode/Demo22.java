package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo22 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode first = pHead;
        if (first.next == null) return null;
        boolean flag = false;
        while ( first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
            if (slow == first) {
                flag = true;
                break;
            }
        }
        if (flag) {
            slow = pHead;
            while (slow != first) {
                slow = slow.next;
                first = first.next;
            }
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        Demo22 d = new Demo22();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l1;

        System.out.println(d.EntryNodeOfLoop(l1).val);
    }
}
