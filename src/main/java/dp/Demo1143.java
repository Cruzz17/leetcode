package dp;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < text2.length(); i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i <= text1.length();i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] =dp[i - 1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length() ][text2.length()];
    }

    public static void main(String[] args) {
        Demo1143 demo1143 = new Demo1143();
        System.out.println(demo1143.longestCommonSubsequence("abcde","ace"));
    }
}
