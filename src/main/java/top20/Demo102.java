package top20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Demo102 {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node != null && node.left != null){
                    queue.add(node.left);
                }
                if(node != null && node.right != null){
                    queue.add(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
        }
        return res;
    }
}
