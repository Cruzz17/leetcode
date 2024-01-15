package listnode;

import top20.ListNode;

/**
 * &#064;Author:  {USER}
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo148 {
    /**
     * 链表排序
     * 头插法超时
     * 需要归并排序
     * 4 2 3 1 6 5
     * 2 4 1 3 5 6
     * 先快慢指针 然后一直递归
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        // 头插法
        return null;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断链
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeTwoListNode(left, right);
    }



    public ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
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
        if (l1 != null) index.next = l1;
        if (l2 != null) index.next = l2;
        return res.next;
    }
}
