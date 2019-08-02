package leetcode;

public class Solution543 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
