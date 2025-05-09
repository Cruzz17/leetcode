package treenode;

import top20.TreeNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM33 {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null) return pRoot;
        TreeNode left = Mirror((pRoot.right));
        TreeNode right = Mirror((pRoot.left));
        pRoot.left = left;
        pRoot.right = right;

        return pRoot;
    }
}
