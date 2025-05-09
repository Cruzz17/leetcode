package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBm14 {
    public ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode oddNode = head;
        ListNode evenNode= head.next;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (oddNode!= null  ) {
            cur.next = new ListNode(oddNode.val);
            cur = cur.next;
            if(oddNode.next == null) break;
            oddNode = oddNode.next.next;
        }

        while (evenNode != null ) {
            cur.next = new ListNode(evenNode.val);
            cur = cur.next;
            if(evenNode.next == null) break;
            evenNode = evenNode.next.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        DemoBm14 demoBm14 = new DemoBm14();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = demoBm14.oddEvenList(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
