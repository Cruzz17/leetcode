package erfen;

import string.Demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;


    }



    public static void main(String[] args) {
        Demo1 demo1= new Demo1();


        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(demo1.search(nums, 0));
    }
}
