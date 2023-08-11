package top20;

/**
 * 交换链表jiedian
 * 1 - 3 - 4- 2
 * 2 - 3 - 4- 1
 */
public class Demo04_swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里操作需要拿pre节点做头节点
        // 1- 2- 3- 4 - 5
        // 2 - 1 - 3 - 4 - 5
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;

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
        Demo04_swap_nodes_in_pairs demo = new Demo04_swap_nodes_in_pairs();
        demo.swapPairs(l1);

    }
}
