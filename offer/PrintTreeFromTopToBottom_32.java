package offer;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToBottom_32 {
    public void printFromTopToBottom(TreeNode tree) {
        if(tree == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
