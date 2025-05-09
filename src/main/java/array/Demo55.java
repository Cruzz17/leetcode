package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo55 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] =  true;
        for(int i = 0; i < nums.length; i++) {
            int step = nums[i];
            for(int j = 1; j <= step; j++) {
                if(i+j < nums.length && dp[i]){
                    dp[i+j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Demo55 demo55 = new Demo55();
        int[] nums = new int[] {0,2,3};
        System.out.println(demo55.canJump(nums));
    }
}
