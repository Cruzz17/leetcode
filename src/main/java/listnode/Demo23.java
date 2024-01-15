package listnode;

import top20.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo23 {
    // 分治法
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }



    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));

        for (ListNode list : lists) {
            if (list == null) continue;
            queue.add(list);
        }

        ListNode res = new ListNode(0);
        ListNode index = res;
        while (!queue.isEmpty()){
            ListNode temp = queue.poll();
            index.next = temp;
            index = index.next;
            if(temp.next != null) queue.add(temp.next);
        }
        return res.next;
    }


    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if(l > r) return null;
        int mid = (r - l) / 2 + l;
        return merge2ListNode(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    public ListNode merge2ListNode(ListNode l1, ListNode l2) {
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
        if (l1 != null) {
            index.next = l1;
        } else if (l2 != null) index.next = l2;
        return res.next;
    }
}
