package treenode;

import top20.TreeNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM35 {
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if (root == null) return true;
        if (root.left == null){
            return root.right == null;
        }
        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }
}
