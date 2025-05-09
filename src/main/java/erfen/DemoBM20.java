package erfen;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM20 {
    public int InversePairs(int[] nums) {
        // write code here
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 从i+1开始找到第一个比nums[i]小的数，如果不是最后一个数，那么dp[i] = dp[j] + 1
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            if (j < nums.length) {
                dp[i] = dp[j] + 1;
            } else {
                dp[i] = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }

        return sum % 1000000007;
    }

    public static void main(String[] args) {
        DemoBM20 demoBM20 = new DemoBM20();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(demoBM20.InversePairs(nums));
    }
}
