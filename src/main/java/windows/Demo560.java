package windows;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo560 {

    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length];

        int count = 0;
        preSum[0] = nums[0];

        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        for (int i = preSum.length - 1; i >= 0; i--) {

            for (int j = i - 1; j >= 0; j--) {
                if (preSum[i] - preSum[j] == k ) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Demo560 demo560 = new Demo560();
        int[] nums = new int[] {0,0};
        System.out.println(demo560.subarraySum(nums, 0));
    }
}
