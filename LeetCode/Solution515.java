package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }


}
