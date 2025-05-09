package treenode;

import top20.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo0716_1 {
    private List<TreeNode> res = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        getInorderList(root);
        int ans = -1;
        for(int i = 0;i < res.size(); i++) {
            TreeNode temp = res.get(i);
            if(temp.val == p.val) {
                ans = i;
            }
        }
        if(ans == -1||ans == res.size() - 1)return null;
        else return res.get(ans +1);
    }
    public void getInorderList(TreeNode root) {
        if(root == null) return;
        getInorderList(root.left);
        res.add(root);
        getInorderList(root.right);
    }

    public static void main(String[] args) {
        //[6,2,8,0,4,7,9,null,null,3,5]
        //2
        TreeNode root = new TreeNode(6);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(8);
        TreeNode l2 = new TreeNode(0);
        TreeNode r2 = new TreeNode(4);
        TreeNode l3 = new TreeNode(7);
        TreeNode r3 = new TreeNode(9);
        TreeNode l4 = new TreeNode(3);
        TreeNode r4 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;
        r2.left = l4;
        r2.right = r4;
        Demo0716_1 demo0716_1 = new Demo0716_1();
        System.out.println(demo0716_1.inorderSuccessor(root, l1).val);



    }
}
