package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new LinkedList<>();
        List<Integer> res2 = new LinkedList<>();
        helper(root1, res1);
        helper(root2, res2);
        return res1.equals(res2);
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
