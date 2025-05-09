package singlestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo42 {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[height.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = 0;
        System.arraycopy(height, 0, arr, 1, height.length);

        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[i] > arr[deque.peek()]) {
                int l = deque.pop();
                if (!deque.isEmpty()) {
                    int h = Math.min(arr[deque.peek()], arr[i])- arr[l];
                    int len = i - deque.peek() - 1;
                    res += h* len;
                }
            }
            deque.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Demo42 demo42 = new Demo42();
        System.out.println(demo42.trap(height));
    }
}
