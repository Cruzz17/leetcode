package treenode;
import top20.TreeNode;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM40 {
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        return reBuildBinaryTree(preOrder, 0, preOrder.length - 1, vinOrder, 0, vinOrder.length - 1);
    }

    public TreeNode reBuildBinaryTree(int[] preOrder, int preStart, int preEnd, int[] vinOrder, int vinStart, int vinEnd){
        if(preStart > preEnd || vinStart > vinEnd) return null;
        TreeNode root =new TreeNode(preOrder[preStart]);
        int index = 0;
        for (int i = vinStart; i <= vinEnd; i++) {
            if(vinOrder[i] == preOrder[preStart]){
                index = i;
                break;
            }
        }
        int leftSize = vinStart - index;
        root.left = reBuildBinaryTree(preOrder, preStart + 1, preStart + leftSize, vinOrder, vinStart, index - 1);
        root.right = reBuildBinaryTree(preOrder, preStart + 1 + index, preEnd, vinOrder, index + 1, vinEnd);
        return root;
    }

}
