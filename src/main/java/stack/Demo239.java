package stack;

import java.util.*;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() == k) {
                res.add(queue.peek());
            }
            if (queue.size() > k) {
                Deque<Integer> temp = new LinkedList<>();
                int tempNum = nums[i - k];
                while (queue.peek() != tempNum) {
                    temp.add(queue.poll());
                }
                queue.poll();
                while (!temp.isEmpty()) {
                    queue.add(temp.pop());
                }
                if(queue.size() == k) {
                    res.add(queue.peek());
                }
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        Demo239 demo239 = new Demo239();
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = demo239.maxSlidingWindow(num, 3);
        System.out.println(Arrays.toString(res));
    }
}
