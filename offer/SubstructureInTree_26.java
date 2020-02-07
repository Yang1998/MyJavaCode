package offer;

public class SubstructureInTree_26 {
    private boolean doesTree1HaveTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return doesTree1HaveTree2(tree1.left, tree2.left) && doesTree1HaveTree2(tree1.right, tree2.right);
    }

    public boolean hasSubtree(TreeNode tree1, TreeNode tree2) {
        boolean res = false;
        if (tree1 != null && tree2 != null) {
            if (tree1.val == tree2.val) {
                res = doesTree1HaveTree2(tree1, tree2);
            }
            if (!res) {
                res = hasSubtree(tree1.left, tree2);
            }
            if (!res) {
                res = hasSubtree(tree1.right, tree2);
            }
        }

        return res;
    }
}
