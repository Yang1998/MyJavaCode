package leetcode;

public class Solution337 {

    public int rob(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
            sum += root.val;
        }
        int tmp = rob(root.left) + rob(root.right);
        return sum > tmp ? sum : tmp;
    }
}
