package dp;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo85 {
    public int maximalRectangle(char[][] matrix) {
        // 如果当前char[i][j] == 1，那么就向右和向下判断最长的，以及右下角最长的值
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1'){
                    int width = dp[i][j];
                    int area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        area = Math.max(area, width * (i - k + 1));
                    }
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Demo85 demo85 = new Demo85();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(demo85.maximalRectangle(matrix));
    }
}
