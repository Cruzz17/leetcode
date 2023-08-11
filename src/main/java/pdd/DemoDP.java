package pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class DemoDP {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] dp = new int[n];

            if(n == 1){
                System.out.println(nums[0]);
                return;
            }
            if (n == 2){
                System.out.println(Math.max(nums[0], nums[1]));
                return;
            }
            if(n == 3) {
                Arrays.sort(nums);
                System.out.println(nums[2]);
                return;
            }

            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            dp[2] = Math.max(dp[1], nums[2]);
            dp[3] = Math.max(dp[2], nums[3]);

            for (int i = 3; i < n; i++) {
                    dp[i] = Math.max(dp[i - 3] + nums[i], Math.max(dp[i - 2], dp[i-1]));
            }
            System.out.println(dp[n - 1]);
        }

}
