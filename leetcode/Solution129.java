package leetcode;

public class Solution129 {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int val) {
        val = val * 10 + root.val;
        if(root.left == null && root.right == null) {
            res += val;
            return;
        }
        if(root.left != null)
            helper(root.left, val);
        if(root.right != null)
            helper(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution129().sumNumbers(root));
    }
}
