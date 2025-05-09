package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);
            int sum = left + right + 1;
            StringBuilder sb = new StringBuilder();
            map.put(nums[i], sum);
            map.put(nums[i] - left, sum);
            map.put(nums[i] + right, sum);
            max = Math.max(max, sum);
        }
        return max;
    }



    public static void main(String[] args) {
        Demo128 demo128 = new Demo128();
        int[] nums = new int[] {100,4,200,1,3,2};
        System.out.println(demo128.longestConsecutive(nums));
    }
}
