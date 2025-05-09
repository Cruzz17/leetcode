package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM15 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode dummy = head;
        ListNode index = head.next;
        while(index != null) {
            int temp = dummy.val;
            while(index.val == temp) {
                index = index.next;
                if(index == null) {
                    dummy.next = null;
                    return head;
                }
            }
            dummy.next = index;
            dummy = dummy.next;
            index = index.next;

        }
        return head;
    }

    public static void main(String[] args) {
        DemoBM15 demoBM15 = new DemoBM15();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode res = demoBM15.deleteDuplicates(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
