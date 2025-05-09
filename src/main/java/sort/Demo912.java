package sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Demo912 {
    Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        // 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> o2 - o1);
        return nums;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition1(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition1(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                System.out.println("增加左指针: " + left);
                left++;
            }
            while (left <= right && arr[right] >= pivot) {
                System.out.println("减少右指针: " + right);
                right--;
            }
            if (left >= right) {
                System.out.println("跳出循环，左指针: " + left + ", 右指针: " + right);
                break;
            }
            System.out.println("交换索引 " + left + " 和 " + right + " 的元素");
            swap(arr, left, right);
            System.out.println("交换后的数组: " + Arrays.toString(arr));
        }
        System.out.println("交换基准元素和索引 " + right + " 的元素");
        swap(arr, low, right);
        System.out.println("最终交换后的数组: " + Arrays.toString(arr));
        return right;

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (true) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] >= pivot) right--;
            if (left >= right) break;
            swap(arr, left, right);
        }
        swap(arr, low, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int[] ints = new int[]{5,2,3,1};
        Demo912 demo912 = new Demo912();
        demo912.sortArray(ints);
        System.out.println(Arrays.toString(demo912.sortArray(ints)));
    }

}
