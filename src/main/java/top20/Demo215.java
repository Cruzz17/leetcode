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

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        return quickSort(nums, 0, nums.length - 1, nums.length - k );
    }
    //  4 3 2 5 9 1 0
    //
    //  5 3 2 9 4 1 0
    public int quickSort(int[] nums, int left, int right, int k){
        int index = partition(left, right, nums);
        if(index == k ){
            return nums[index];
        }else {
            return index < k ? quickSort(nums, index + 1, right, k) :
                    quickSort(nums, left, index - 1, k);
        }
    }

    public int partition(int left, int right, int[] nums) {
        int ran = random.nextInt(right - left + 1) + left;
        swap(nums, ran, left);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right ; i++) {
            if(nums[i] < pivot){
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    public String print(int[] nums ){
        StringBuffer s = new StringBuffer();
        for (int i:
             nums) {
            s.append(i).append(" ");
        }
        return s.toString();
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 5, 1, 9, 0};
        Demo215 demo215 = new Demo215();
        demo215.partition(0, 6,nums);
    }
}
