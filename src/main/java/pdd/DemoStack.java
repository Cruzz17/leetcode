package pdd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class DemoStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            for (int i = 0; i < n; i++) {
                stack.push(a[i]);
                while (!stack.isEmpty() && stack.peek() == b[j]) {
                    stack.pop();
                    j++;
                }
            }
            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }
}
