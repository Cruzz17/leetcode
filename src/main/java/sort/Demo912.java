package sort;

import java.util.Arrays;
import java.util.Random;

public class Demo912 {
    Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        // 递归终止条件
        if(left >= right) return;
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);

    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int lt = left;
        // 从left + 1开始，因为left是基准值
        // lt是小于基准值的最后一个元素的索引
        // 当前元素小于基准值，lt++，如果当前元素大于基准值，不用管，lt不变
        //lt 和i的元素交换的时候，lt的元素是小于基准值的，i的元素是大于基准值的
        // 整个的动画是这样的，基准值是4，lt是0，i是1，i的元素是3，3小于4，lt++，
        // lt的元素和i的元素交换，交换后的数组是3，4，2，5，1，9，0

        for (int i = left + 1; i <= right; i++) {
            if(nums[i] < pivot){
                lt++;
                if(lt != i){
                    swap(nums, lt, i);
                }

            }
        }
        swap(nums, left, lt);
        return lt;
    }


    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        System.out.println(Arrays.toString(nums));
    }



    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+ 1; j < nums.length ; j++) {
                if(nums[i] > nums[j]){
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    public int[] chooseSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            // 找到最小的元素，然后交换
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4, 3, 2, 5, 1, 9, 0};
        Demo912 demo912 = new Demo912();
        demo912.sortArray(ints);
        System.out.println(Arrays.toString(ints));
    }

}
