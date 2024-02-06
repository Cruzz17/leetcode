package windows;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo209 {
    public int minSubArrayLen(int target, int[] nums) {
        //遍历肯定不行，需要用滑动窗口
        Map<Integer, Integer> win = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = i;
        while (i <= j && j < nums.length) {
            int temp = win.getOrDefault(nums[j], 0);
            win.put(nums[j], temp + 1);
            sum += nums[j];
            while (sum >= target && i <= j) {
                res = Math.min(res, j - i + 1);
                int del = win.get(nums[i]);
                win.put(nums[i], del - 1);
                sum = sum - nums[i];
                i++;
            }
            j++;

        }
        return res;
    }

    public static void main(String[] args) {
        Demo209 demo209 = new Demo209();
        int[] nums = new int[]{1,4,4};
        System.out.println(demo209.minSubArrayLen(4, nums));
    }
}
