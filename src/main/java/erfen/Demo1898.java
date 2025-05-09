package erfen;

import pdd.Demo32;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;
        boolean[] removed = new boolean[s.length()];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isSubsequence(s, p, removable, mid, removed)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isSubsequence(String s, String p, int[] removable, int k, boolean[] removed) {
        Arrays.fill(removed, false);
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        Demo1898 demo1898 = new Demo1898();
        String s1 = "qobftgcueho";
        String s2 = "obue";
        System.out.println(demo1898.maximumRemovals(s1, s2, new int[]{5,3,0,6,4,9,10,7,2,8}));

    }
}
