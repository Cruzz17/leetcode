package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class LCRDemo25 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        ListNode l1 = reverse(head1);
        ListNode l2 = reverse(head2);
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            index.next = new ListNode(sum % 10);
            index = index.next;
        }

        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {

        //[5,9,7,5,7,1,2,6,4,2,7,8,9,6,1,6,6,1,1,4,2,9,5,5,0,4,6,3,0,4,3,5,6,7,0,5,5,4,4,0],[1,3,2,5,0,6,0,2,1,4,3,9,3,0,9,9,0,3,1,6,5,7,8,6,2,3,8,5,0,9,7,9,4,5,9,9,4,9,3,6]

        LCRDemo25 demo25 = new LCRDemo25();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(7);
    }
}
