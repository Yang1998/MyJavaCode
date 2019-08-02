package leetcode;

public class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        new Solution538().convertBST(root);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
