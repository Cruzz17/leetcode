package listnode;

import top20.ListNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM16 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);  // 创建虚拟头节点
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;  // 跳过所有相同值的节点
            }
            if (prev.next == cur) {  // 如果当前节点值与prev.next值不同
                prev = prev.next;  // 更新prev
            } else {
                prev.next = cur.next;  // 跳过所有相同值的节点
            }
            cur = cur.next;
        }
        return dummy.next;  // 返回结果链表的头节点
    }

    public static void main(String[] args) {
        DemoBM16 demoBM16 = new DemoBM16();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode res = demoBM16.deleteDuplicates(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
