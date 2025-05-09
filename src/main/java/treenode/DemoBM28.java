package treenode;
import top20.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM28 {

    public int maxDepth (TreeNode root) {
        // write code here
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int res = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if(treeNode != null){
                    if( treeNode.left != null) {
                        deque.add(treeNode.left);
                    }
                    if(treeNode.right != null) {
                        deque.add(treeNode.right);
                    }
                }

            }
            res++;
        }
        return res;
    }
}
