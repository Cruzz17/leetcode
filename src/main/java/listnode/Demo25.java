package listnode;

import top20.ListNode;

/**
 * &#064;Author:  {USER}
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:   给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Demo25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        ListNode resTemp = res;
        ListNode index = head;
        ListNode count = head;
        int countNum = 0;
        while (count != null) {
            count = count.next;
            countNum++;
        }
        int groupNum = countNum / k;
        for (int i = 0; i < groupNum; i++) {
            ListNode temp = index;
            ListNode  point = new ListNode(0);
            point.next = index;
            for (int j = 0; j < k; j++) {
                index = index.next;
                point = point.next;
            }
            point.next = null;
            resTemp.next = reverseListNode(temp);
            while (resTemp.next != null){
                resTemp = resTemp.next;
            }

        }
        resTemp.next = index;
        return res.next;
    }

    public ListNode reverseListNode(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode temp = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        Demo25 demo25 = new Demo25();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        demo25.reverseKGroup(l1, 2);
    }
}
