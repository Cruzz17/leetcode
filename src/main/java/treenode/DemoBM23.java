package treenode;

import top20.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM23 {
    List<Integer> list = new ArrayList<>();

    public int[] preorderTraversal (TreeNode root) {
        // write code here
        preOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void preOrder(TreeNode root) {
        if(root == null) return;
        if(root.left !=null) preOrder(root.left);
        list.add(root.val);
        if(root.right != null) preOrder(root.right);

    }

    public static void main(String[] args) {
        DemoBM23 demoBM23 = new DemoBM23();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.right = l1;
        l1.left = r1;
        int[] res = demoBM23.preorderTraversal(root);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
