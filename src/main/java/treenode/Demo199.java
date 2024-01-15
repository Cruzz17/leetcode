package treenode;

import top20.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * &#064;Author: san.m
 * &#064;Date:  {DATE} {TIME}
 * &#064;Description:
 */
public class Demo199 {

    // 二叉树的右视图 先用二叉树的层序遍历吧
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (res.size() < level) {
                    if (temp != null) {
                        res.add(temp.val);
                    }
                }
                if(temp != null) {
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                    if(temp.left != null) {
                        queue.add(temp.left);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo199 demo199 = new Demo199();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        root.left = left;

        TreeNode right1 = new TreeNode(4);

        left.left = right1;
        System.out.println(demo199.rightSideView(root));
    }
}
