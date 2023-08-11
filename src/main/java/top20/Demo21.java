package top20;

public class Demo21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (list1 != null && list2 != null){
            if(list1.val > list2.val){
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }else  {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
                temp = temp.next;
            }
        }
        if(list1 == null && list2 != null){
            temp.next = list2;
        }
        if(list1 != null && list2 == null){
            temp.next = list1;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Demo21 demo21 = new Demo21();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        demo21.mergeTwoLists(l1, l4);
    }
}
