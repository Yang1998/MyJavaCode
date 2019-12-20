package leetcode;

public class Solution606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }
    private void helper(TreeNode root, StringBuilder sb) {
        if(root == null)
            return;
        sb.append(root.val);
        if(root.left != null) {
            sb.append("(");
            helper(root.left, sb);
            sb.append(")");
        }
        else{
            if(root.right != null) {
                sb.append("()");
            }
        }
        if(root.right != null) {
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }
}
