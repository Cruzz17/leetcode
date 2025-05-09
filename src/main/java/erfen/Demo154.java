package erfen;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo154 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //如果中间元素比右边元素大，说明最小值在右边
            if (nums[mid] > nums[r]) {
                l = mid + 1;
                // 如果中间元素比右边元素小，说明最小值在左边
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }

        }
        return nums[l];
    }

    public static void main(String[] args) {
        Demo154 demo154 = new Demo154();
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(demo154.findMin(nums));
    }
}
