package leetcode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        TreeNode root = null;
        if(l <= r) {
            int mid = l + (r - l) / 2;
            root = new TreeNode(nums[mid]);
            root.left = helper(nums, l, mid-1);
            root.right = helper(nums, mid + 1, r);
        }
        return root;
    }
}
