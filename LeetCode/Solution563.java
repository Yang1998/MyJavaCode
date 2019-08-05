package leetcode;

public class Solution563 {
    int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        int rootVal = root.val;
        helper1(root);
        return res;
    }

    private int helper1(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null )
            return root.val;
        int a = helper1(root.left);
        int b = helper1(root.right);
        root.val += a + b;
        res += Math.abs(a - b);
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(new Solution563().findTilt(root));
    }
}
