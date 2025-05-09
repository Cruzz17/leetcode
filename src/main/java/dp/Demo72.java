package dp;

import java.util.Scanner;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo72 {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        int l1 = word1.length();
        int l2 = word2.length();
        for(int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i<= l1; i++) {
            for(int j = 1; j<= l2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i -1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return  dp[l1][l2];

    }

    public int minDNA(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 0; i<=l1;i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i<= l2;i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i<= l1; i++) {
            for(int j = 1; j<= l2; j++){
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i -1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return  dp[l1][l2];
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String input = "";
        // get character stream from keyboard
        if (scan.hasNext()) {
            input = scan.nextLine();
        }
        scan.close();
        String[] array = input.split(",");


    }
}
