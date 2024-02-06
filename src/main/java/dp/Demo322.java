package dp;

import java.util.Arrays;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<=amount; i++) {
            for (int coin: coins) {
                if(i >= coin){
                    int cnt = i - coin;
                    if (cnt == 0) dp[i]=1;
                    else {
                        if(dp[cnt] != Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[cnt] + 1, dp[i]);
                        }
                    }
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1:dp[amount];
    }

    public static void main(String[] args) {
        Demo322 demo322 = new Demo322();

        int[] coins = new int[] {1};
        System.out.println(demo322.coinChange(coins, 0));

    }
}
