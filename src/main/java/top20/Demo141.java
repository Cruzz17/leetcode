package top20;

public class Demo141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode first = head.next;
        ListNode slow = head;
        while (first !=null && first.next != null){
            if(first == slow){
                return true;
            }else {
                first = first.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}
