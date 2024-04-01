package listnode;

import top20.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 */
public class Demo143 {
    // 用一个栈存储
    public void reorderList(ListNode head) {
        ListNode temp = head;
        ListNode first = head;
        ListNode slow = head;
        while (first != null && first.next != null) {
            slow = slow.next;
            temp = temp.next;
            first = first.next.next;
        }
        ListNode reverse = reverseListNode(slow.next);
        temp.next = null;
        head = mergeListNode(head, reverse);
    }
    // 反转链表， 递归法
    public ListNode reverseListNode(ListNode head) {
        if (null == head || head.next == null ) {
            return head;
        }
        ListNode temp  = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode index = res;
        while (l1 != null && l2 != null) {
            index.next = l1;
            l1 = l1.next;
            index = index.next;
            index.next = l2;
            l2 = l2.next;
            index =  index.next;
        }
        if(l1 != null) index.next = l1;
        if(l2 != null) index.next = l2;
        return res.next;
    }

    public static void main(String[] args) {
        Demo143 demo143 = new Demo143();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        //demo143.pushNode2Stack(l1, new Stack<>());
        demo143.reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

}
