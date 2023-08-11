package listnode;

import top20.ListNode;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        ListNode resTemp = res;
        ListNode index = head;
        while (index != null){
            if(!judgeListNodeDup(index)){
                resTemp.next = index;
                resTemp = resTemp.next;
                index = index.next;
            }else {
                ListNode temp = getFirstNotDuplicate(index, index.val);
                if(temp == null){
                    resTemp.next = temp;
                    return res.next;
                }
                index = temp;
            }
        }
        return res.next;
    }
    // 找到下一个不重复的点
    public ListNode getFirstNotDuplicate(ListNode head, int val) {
        if(head == null) return null;
        while (head != null){
            if(head.val != val) return head;
            else head=head.next;
        }
        return null;
    }
    // 判断该节点是否重复
    public boolean judgeListNodeDup(ListNode head) {
        if(head == null || head.next==null ) return false;
        return head.val == head.next.val;

    }

    public static void main(String[] args) {
        Demo82 demo82 = new Demo82();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);

        l1.next=l2;
        l2.next = l3;


        ListNode res = demo82.deleteDuplicates(l1);
        System.out.println(res.val);
    }
}
