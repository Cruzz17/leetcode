package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo41 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i - 1 && nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Demo41 demo41 = new Demo41();
        int[] nums = new int[]{1,2,2,1,3,1,0,4,0};
        System.out.println(demo41.firstMissingPositive(nums));
    }
}
