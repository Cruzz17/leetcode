package top20;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * 维持一个k个的最大的队列，只有2个,要么是大根堆，要么是手写快排, 主要就是这两种解法
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Demo215 {
    Random random = new Random();

    // 如何自己手写一个大根堆的优先队列


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                // 如果当前元素大于堆顶元素，就把堆顶元素弹出，把当前元素加入
                // 如果当前元素小于堆顶元素，就不用管，大根堆的特性，堆顶元素最大，所以不用管，poll方法的作用是弹出堆顶元素
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    //  4 3 2 5 9 1 0
    //
    //  5 3 2 9 4 1 0
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int quickSort(int[] nums, int l, int r, int k) {
        if (l <= r) {
            int index = pivot(nums, l, r);
            int cur = nums.length - k;
            if (index == cur) return nums[index];
            else {
                if (index > cur) {
                    return quickSort(nums, l, index - 1, k);
                } else {
                    return quickSort(nums, index + 1, r, k);
                }
            }
        }
        return -1;
    }

        public int pivot ( int[] nums, int l, int r){
            int index = nums[l];
            int left = l + 1;
            int right = r;
            while (left <= right) {
                while (left <= right && nums[left] <= index) left++;
                while (left <= right && nums[right] > index) right--;
                if (left < right) {
                    swap(nums, left, right);
                }
            }
            swap(nums, l, right);
            return right;
        }

        public void swap ( int[] nums, int l, int r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        public static void main (String[]args){
            int[] nums = new int[]{2,1};
            Demo215 demo215 = new Demo215();
            System.out.println(demo215.findKthLargest2(nums, 2));
        }
    }
