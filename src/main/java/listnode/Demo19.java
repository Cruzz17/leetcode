package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode countNode = head;
        while (countNode != null) {
            countNode = countNode.next;
            count++;
        }
        if(n == count) {
            return head.next;
        }
        ListNode res = head;
        while (count - n > 1) {
            res = res.next;
            count--;
        }
        if(res.next != null) {
            ListNode temp = res.next.next;
            res.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Demo19 demo19 = new Demo19();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);


        l1.next = l2;

        ListNode res = demo19.removeNthFromEnd(l1,1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
