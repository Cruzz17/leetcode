package stack;

import java.util.*;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM45 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here,会有重复数字，所以不能用set，但是arrayList也不对

        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0 || size > num.length) return res;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.getFirst() == i - size) {
                deque.removeFirst();
            }
            if (i >= size - 1) {
                res.add(num[deque.getFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DemoBM45 demoBM45 = new DemoBM45();
        int[] num = {4,2,3,1};
        ArrayList<Integer> res = demoBM45.maxInWindows(num, 3);
        System.out.println(res);
    }
}
