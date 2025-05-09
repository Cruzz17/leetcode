package treenode;

import array.Demo;
import top20.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean dirt = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.pop();
                cur.add(temp.val);
                if(temp.left != null ) {
                    queue.add(temp.left);
                }
                if(temp.right != null) queue.add(temp.right);
            }
            if(dirt) {
                res.add(reverse(cur));
            }else {
                res.add(cur);
            }
            dirt = !dirt;
        }
        return res;
    }


    public List<Integer> reverse(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        int size = list.size();
        for (int j = size -1; j >=0; j--) {
            res.add(list.get(j));
        }
        return res;
    }

    public static void main(String[] args) {

        Demo103 demo103 = new Demo103();
        // [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        right.right = right1;
        List<List<Integer>> res = demo103.zigzagLevelOrder(root);
        System.out.println(res);

    }

}
