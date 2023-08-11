package top20;

public class Demo121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
        if(len == 2){
            if(prices[0] >= prices[1]){
                return 0;
            }
            else {
                return prices[1] - prices[0];
            }
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i-1][1] );
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return Math.max(dp[len -1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        Demo121 demo121 = new Demo121();

        int[] prices = new int[]{7,1, 3, 4, 6,5};
        System.out.println(demo121.maxProfit(prices));
    }
}
