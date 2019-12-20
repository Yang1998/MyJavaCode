package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            double cnt = 0.0;
            for(int i = 0; i < n; ++i) {
                TreeNode tmp = queue.poll();
                cnt += tmp.val;
                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
            res.add(cnt / n);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution637().averageOfLevels(root));
    }
}
