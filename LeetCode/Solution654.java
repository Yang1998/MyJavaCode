package leetcode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if(l <= r) {
            int index = l;
            for (int i = l; i <= r; i++) {
               if(nums[index] < nums[i])
                   index = i;
            }

            TreeNode root = new TreeNode(nums[index]);
            root.left = helper(nums, l, index - 1);
            root.right = helper(nums, index + 1, r);
            return root;
        }
        return null;
    }
}
