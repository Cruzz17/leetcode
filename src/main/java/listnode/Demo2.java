package listnode;

import top20.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }


    public int getRandom(Map<Integer, Integer> cap) {
        int size = cap.size();
        Random random = new Random();
        int i = random.nextInt(size);
        ListIterator<Map.Entry<Integer, Integer>> iterator =
                new ArrayList<>(cap.entrySet()).listIterator();

        Map.Entry<Integer, Integer> entry = iterator.next();
        Integer key = entry.getKey();
        return key;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        Demo2 demo2 = new Demo2();
        demo2.addTwoNumbers(l1, l4);
    }
}
