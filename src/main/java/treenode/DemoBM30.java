package treenode;

import top20.TreeNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM30 {
    private TreeNode lastNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        TreeNode headNode = lastNode;
        while (headNode != null && headNode.left != null) {
            headNode = headNode.left;
        }
        return headNode;
    }

    private void convertNode(TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            convertNode(node.left);
        }

        node.left = lastNode;
        if (lastNode != null) {
            lastNode.right = node;
        }

        lastNode = node;

        if (node.right != null) {
            convertNode(node.right);
        }
    }


    public static void main(String[] args) {
        DemoBM30 demoBM30 = new DemoBM30();
        // 10,6,14,4,8,12,16
        TreeNode root = new TreeNode(10);

        TreeNode l1 = new TreeNode(6);
        TreeNode r1 = new TreeNode(14);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(8);
        TreeNode l3 = new TreeNode(12);
        TreeNode r3 = new TreeNode(16);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;
        TreeNode res = demoBM30.Convert(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.right;
        }
        System.out.println(res);
    }
}
