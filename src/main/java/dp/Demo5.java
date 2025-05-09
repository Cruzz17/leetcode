package dp;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo5 {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int start = 0;
        int max = 1;
        // dp[i][j] = 1 表示 s[i:j] 是回文串，0 表示不是，如果是回文串，那么 s[i] == s[j] && dp[i+1][j-1] == 1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                max = 2;
            }
        }
        // len 表示当前子串的长度，为什么要从3开始，因为 1 和 2 的情况已经处理了，
        // 此处需要注意的是，i 从 0 开始，j 从 i + len - 1 开始，不然会出现数组越界，
        // 为什么要这样开始遍历，因为我们要保证 dp[i+1][j-1] 已经计算过了，所以要从小到大开始遍历
        // 有没有简单的dp，不需要根据长度来进行遍历，因为这样很多都是重复的，比如 dp[i][j] = 1，那么 dp[i+1][j-1] 也是 1


        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    max = len;
                }
            }
        }
        return s.substring(start, start + max);
    }


    /*
    双指针做法
     */
    public String longestPalindrome2(String s) {
        s= 1 + s + 2;
        int start = 0;
        int maxLen = 0;
        // 先处理单个情况的
        for (int i = 1; i < s.length()-1 ; i++) {
            int l = i - 1;
            int r = i + 1;
            while ( l >= 0 && r <= s.length() -1 ) {
                if (s.charAt(l) == s.charAt(r)) {
                    start = l;
                    maxLen = Math.max(maxLen, r - l + 1);
                }
                l--;
                r++;
            }
        }
        return s.substring(start, maxLen + start);
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        System.out.println(demo5.longestPalindrome2("aaabcbadf"));
    }
}
