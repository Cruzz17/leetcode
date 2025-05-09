package stack;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0) return res;
        PriorityQueue<Integer> queue = new PriorityQueue<>( (o1, o2) -> o1 - o2);
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else if (queue.peek() > input[i]) {
                queue.poll();
                queue.add(input[i]);
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        DemoBM46 demoBM46 = new DemoBM46();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = demoBM46.GetLeastNumbers_Solution(input, 4);
        System.out.println(res);
    }
}
