package erfen;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo153 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //如果中间元素比右边元素大，说明最小值在右边
            if (nums[mid] > nums[r]) {
                l = mid + 1;
                // 如果中间元素比右边元素小，说明最小值在左边
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }

        }
        return nums[l];

    }

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // 添加元素到队列的头部
        deque.addFirst("Element 1 (Head)");

        // 添加元素到队列的尾部
        deque.addLast("Element 2 (Tail)");

        // 将元素推入队列的头部
        deque.push("Element 3 (Head)");

        // 将元素添加到队列的尾部
        deque.offer("Element 4 (Tail)");

        // 打印队列
        System.out.println("Deque: " + deque);

        // 删除头部元素
        String headElement = deque.removeFirst();
        System.out.println("Removed from head: " + headElement);
        System.out.println("Deque after removal: " + deque);

        // 删除尾部元素
        String tailElement = deque.removeLast();
        System.out.println("Removed from tail: " + tailElement);
        System.out.println("Deque after removal: " + deque);
    }
}
