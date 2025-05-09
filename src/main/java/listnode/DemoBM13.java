package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM13 {
    public boolean isPail (ListNode head) {
        // write code here
        ListNode index = head;
        ListNode tail = reverse(index);
        while(head != null) {
            if(head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
       ListNode newHead = null;
       while(head != null) {
           ListNode newNode = new ListNode(head.val);  // 创建新节点
           newNode.next = newHead;
           newHead = newNode;
           head = head.next;
       }
       return newHead;
    }

    public static void main(String[] args) {
        //{1,2,3,4,5,4,3,2,1,1}
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(3);
        ListNode l8 = new ListNode(2);
        ListNode l9 = new ListNode(1);
        ListNode l10 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;

        DemoBM13 demoBM13 = new DemoBM13();
        System.out.println(demoBM13.isPail(l1));


    }
}
