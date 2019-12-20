package leetcode;

import java.lang.reflect.WildcardType;
import java.util.LinkedList;
import java.util.Queue;

public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode LastRetHead = root;
        while (!queue.isEmpty()) {
            LastRetHead = queue.peek();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return LastRetHead.val;
    }
}
