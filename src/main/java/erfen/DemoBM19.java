package erfen;

import listnode.DemoBm14;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM19 {
    public int res = 0;
    public int findPeakElement (int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = Integer.MIN_VALUE;
        arr[arr.length - 1] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        // write code here
        judagePeak(arr,0,arr.length - 1);
        return res -1;
    }

    public void judagePeak(int[] nums, int left, int right) {
        if(left >= right - 1) return;
        int mid = (right - left) / 2 + left;
        if(mid > 0 && nums[mid -1] < nums[mid] && nums[mid+1] < nums[mid]){
            res = mid;
        }else {
            judagePeak(nums, left, mid);
            judagePeak(nums, mid, right);
        }

    }

    public static void main(String[] args) {
        DemoBM19 demoBm19 = new DemoBM19();
        int[] nums = {2};
        System.out.println(demoBm19.findPeakElement(nums));

    }
}
