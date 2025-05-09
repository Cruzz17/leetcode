package erfen;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM21 {
    public int minNumberInRotateArray(int[] nums) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        DemoBM21 demoBM21 = new DemoBM21();
        int[] nums = new int[]{2, 2, 2, 2, 1, 2};
        System.out.println(demoBM21.minNumberInRotateArray(nums));
    }
}
