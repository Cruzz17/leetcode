package treenode;

import top20.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM39 {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        buildString(root, sb);
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.isEmpty()) return null;


        String[] nodes = str.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));

        return buildTree(queue);
    }

    TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val == null || val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);

        return node;
    }

    void buildString(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        buildString(root.left, sb);
        sb.append(",");
        buildString(root.right, sb);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        DemoBM39 demoBM39 = new DemoBM39();
        String s = demoBM39.Serialize(root);
        System.out.println(s);
        TreeNode res = demoBM39.Deserialize(s);
        System.out.println(res.val);

    }
}
