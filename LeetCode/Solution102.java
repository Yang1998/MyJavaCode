package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>(new LinkedList<>());
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0;i < n; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
