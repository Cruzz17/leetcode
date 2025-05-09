package treenode;

import top20.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo124 {
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return res;
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = Integer.MAX_VALUE; // Initialize res to MAX_VALUE for minimization
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        for (int i = 1; i < n - 1; i++) { // Start from 1 and end at n-2 to ensure peak is not at the ends
            if (left[i] > 1 && right[i] > 1) { // Ensure valid mountain peak
                res = Math.min(res, n - (left[i] + right[i] - 1)); // Minimize the removals
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res; // Return 0 if no valid mountain array can be formed
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, left + right + root.val);
        //为什么要返回的是max(left, right) + root.val呢？
        //因为我们要找的是以当前节点为根节点的最大路径和，所以只能返回一个方向的路径，而不能同时返回两个方向的路径
        //如果root是负值呢，那这样不就变小了吗？
        //不会，因为我们在dfs的时候已经取了max(0, dfs(root.left))和max(0, dfs(root.right))，如果是负值，那么就不取了，直接取0
        // 可是如果root是负的，但是我们取0不是left和right取0吗
        //是的，但是我们在res = Math.max(res, left + right + root.val);这一步已经取了最大值了，所以不会有问题
        //
        return Math.max(left, right) + root.val;
    }
}
