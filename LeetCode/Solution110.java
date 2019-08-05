package leetcode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        else {
            return false;
        }
    }

    private int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
