package top20;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 */
public class Demo53 {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        res = dp[0];
        if(len == 1){
            return nums[0];
        }
        System.arraycopy(nums, 0, dp, 0, len);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Demo53 demo53 = new Demo53();
        int[] nums  = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(demo53.maxSubArray(nums));
    }
}
