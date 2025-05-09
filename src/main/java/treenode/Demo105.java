package treenode;

import top20.TreeNode;

import java.util.Arrays;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeByLen(preorder,0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeByLen(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if(inOrder[i]==preOrder[preStart]){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;

        // 打印前序和中序的各个边界以及数组的值
        System.out.println("前序遍历开始索引: " + preStart + ", 前序遍历结束索引: " + preEnd);
        System.out.println("前序遍历数组: " + Arrays.toString(Arrays.copyOfRange(preOrder, preStart, preEnd + 1)));
        System.out.println("左子树的数量" + leftSize);
        System.out.println("中序遍历开始索引: " + inStart + ", 中序遍历结束索引: " + inEnd);
        System.out.println("中序遍历数组: " + Arrays.toString(Arrays.copyOfRange(inOrder, inStart, inEnd + 1)));

        TreeNode left = buildTreeByLen(preOrder, preStart + 1 , preStart + leftSize, inOrder, inStart,   index - 1);
        TreeNode right = buildTreeByLen(preOrder, preStart + 1 + leftSize ,  preEnd, inOrder, index + 1, inEnd);
        root.left = left;
        root.right =right;
        return root;
    }


    public static void main(String[] args) {
        Demo105 demo105 = new Demo105();
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] order = new int[]{4,7,2,1,5,3,8,6};
        TreeNode treeNode = demo105.buildTree(pre,order);
        System.out.println(treeNode.val);

    }
}
