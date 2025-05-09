package treenode;

import top20.TreeNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM34 {

    public int MinVal = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root, long min, long max) {
        // write code here
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static void main(String[] args) {
        DemoBM34 demoBM34 = new DemoBM34();
        // 32514
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(5);
        TreeNode l2 = new TreeNode(1);
        TreeNode r2 = new TreeNode(4);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        r1.left = r2;
        System.out.println(demoBM34.isValidBST2(root));
    }
}
