package offer;

public class SymmetricalBinaryTree_28 {
    public boolean isSymmetrical(TreeNode tree) {
        return isSymmetrical(tree, tree);
    }

    private boolean isSymmetrical(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        }
        if(tree1 == null || tree2 == null) {
            return false;
        }
        if(tree1.val != tree2.val) {
            return false;
        }
        return isSymmetrical(tree1.left, tree2.right) && isSymmetrical(tree1.right, tree2.left);
    }
}
