package leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * 法1：对给定树， 如果左子树等于右子树， 右子树等于左子树，则对称
 * 法2： 给定树为Tree1， 将其翻转得到Tree2， 如果将个树相等，则对称
 */

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
//        法1
        return isSymmetric(root, root);

//        法2
//        TreeNode iroot = invertTree(root);
//        return isSameTree(root, iroot);
    }
    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 ==null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }


    private TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    private boolean isSameTree(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null)
            return true;
        if(r1 == null || r2 ==null)
            return false;

        return (r1.val == r2.val) && isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }
}
