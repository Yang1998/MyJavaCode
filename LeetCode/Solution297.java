package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(new Codec().serialize(root));

        final TreeNode deserialize = new Codec().deserialize(new Codec().serialize(root));

        System.out.println(new Codec().serialize(deserialize));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        StringBuilder sb = new StringBuilder("[");
        queue.add(root);
        if (root == null) flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (flag) {
                if (size > 1) {
                    break;
                } else {
                    sb.append("null");
                    break;
                }
            }
            flag = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                } else {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                if (node != null && (node.left != null || node.right != null)) {
                    flag = false;
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == ',')
            sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder(data);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        String[] vals = sb.toString().split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int idx = 1;
        TreeNode root = null;
        root = addNode(vals[0]);
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (idx < vals.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                node.left = addNode(vals[idx++]);
                node.right = addNode(vals[idx++]);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    private TreeNode addNode(String s) {
        if ("null".equals(s)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }

}
