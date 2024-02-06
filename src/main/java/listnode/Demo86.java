package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo86 {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0) ;
        ListNode smallIndex = small;
        ListNode bigIndex = big;
        ListNode index = head;
        while(index != null) {
            if(index.val < x){
                smallIndex.next = index;
                smallIndex = smallIndex.next;
            }else {
                bigIndex.next = index;
                bigIndex = bigIndex.next;

            }
            index = index.next;
        }
        bigIndex.next = null;
        smallIndex.next = big.next;
        res.next = small.next;
        return res.next;
    }

    public static void main(String[] args) {
        Demo86 demo86 = new Demo86();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode res = demo86.partition(l1,3);
    }
}
