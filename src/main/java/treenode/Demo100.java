package treenode;

import top20.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
