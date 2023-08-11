package top20;

/**
 * 反转链表
 *  1- 2- 3- 4- 5- null
 *  此题有2种做法，一种头插法，一种递归法
 */
public class Demo206_reverseList {
    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        head = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

    /**
     * 头插法
     * @param head
     * @return
     * 1-2-3-4-5
     */
    public ListNode reverseList2(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode res = new ListNode(0);
        while (head != null){
            ListNode temp = res.next;
            res.next = new ListNode(head.val);
            res.next.next = temp;
            head = head.next;
        }
        return res.next;
    }

    /**
     * 双指针法
     * 类似于头插法
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Demo206_reverseList demo = new Demo206_reverseList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = demo.reverseList2(l1);

    }
}
