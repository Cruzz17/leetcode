package listnode;

import top20.ListNode;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        return null;
    }

    public ListNode merge2ListNode(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode index = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                index.next = l2;
                l2 = l2.next;
            } else {
                index.next = l1;
                l1 = l1.next;
            }
            index = index.next;
        }
        if (l1 != null) {
            index.next = l1;
        } else if (l2 != null) index.next = l2;
        return res.next;
    }
}
