package pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class DemoPackgket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1] * a[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int w = scanner.nextInt();
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (sum[mid] <= w) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l);
        }
    }
}
