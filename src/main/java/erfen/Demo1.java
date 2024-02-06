package erfen;

import string.Demo3;

import java.util.Arrays;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo1 {
    public int[] twoSum(int[] nums, int target) {
        //
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while ( l < r) {
            int mid = l + (r - l) / 2;
            int temp = nums[l] + nums[r];
            if(temp == target) return new int[]{l,r};
            else if (temp > target) r = mid;
            else l = mid;
        }
        return null;
    }

    public static void main(String[] args) {
        Demo1 demo1= new Demo1();
        int[] nums = new int[] {};
        demo1.twoSum(nums, 9);
    }
}
