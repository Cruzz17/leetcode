package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM12 {
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode l1 = sortInList(head);
        l2 = sortInList(l2);
        return merge2Node(l1, l2);

    }

    public ListNode merge2Node(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while(l1 !=null && l2!= null) {
            if(l1.val < l2.val) {
                index.next = l1;
                l1 = l1.next;
            }else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        if(l1 != null) {
            index.next= l1;
        }else if (l2 != null) {
            index.next = l2;
        }
        return dummy.next;

    }
}
