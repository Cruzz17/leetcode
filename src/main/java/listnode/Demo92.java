package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next ;
        //
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    /**
     *  1 - 2- 3- 4- 5- null
     *
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head) {
        if( head.next == null) return  head;
        ListNode temp = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Demo92 demo92 = new Demo92();
        demo92.reverseBetween(l1,2,4);
    }
}
