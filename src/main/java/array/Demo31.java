package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo31 {

    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     * <p>
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的
     * 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * <p>
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列
     *
     * @param nums
     */
    List<List<Integer>> res = new ArrayList<>();

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int j = len - 1;
        boolean flag = true;
        while (j > 0 ){
            if(nums[j] > nums[j - 1]){
                j = j - 1;
                flag = false;
                break;
            }
            j--;
        }
        if(j == 0 && flag) {
            reverseNum(nums, 0, len - 1);
            return;
        }

        int target = len -1;
        while (target>0){
            if(nums[target] > nums[j]) break;
            target--;
        }

        swap(nums, j, target);
        reverseNum(nums, j + 1, len - 1);
    }

    public void reverseNum(int[] nums, int start, int end) {
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        Demo31 demo31 = new Demo31();
        demo31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
