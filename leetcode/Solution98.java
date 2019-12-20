package leetcode;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    private boolean helper(TreeNode root, Integer lower, Integer higher) {
        if(root == null)
            return true;
        int val = root.val;
        if(lower != null && lower >= val) return false;
        if(higher != null && higher <= val) return false;

        return helper(root.left, lower, val) && helper(root.right, val, higher);
    }
}
