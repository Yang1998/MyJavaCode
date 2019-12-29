package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution5153 {
    public int deepestLeavesSum(TreeNode root) {
        // 层序遍历即可
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> childs = new LinkedList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            if(childs.size() != 0) {
                childs.clear();
            }
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                childs.add(cur);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        // 求和childs数据即可
        for (TreeNode child : childs) {
            res += child.val;
        }
        return res;
    }
}
