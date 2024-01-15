package array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo26 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                j++;
            } else {
                j++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {-3,-1,0,0,0,3,3};
        int res = new Demo26().removeDuplicates(nums);
        System.out.println(res);
    }
}
