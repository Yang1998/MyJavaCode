package leetcode;

/**
 * 两种方法
 */
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return root;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.left == null && root.right == null && root.val == 0)
            root = null;
        return root;
    }
//     public TreeNode pruneTree(TreeNode root) {
//         if(root == null)
//             return root;
//         if(sum(root) == 0)
//             root = null;
//         if(root != null) {
//         root.left = pruneTree(root.left);
//         root.right = pruneTree((root.right));
//         }
//         return root;
//     }

//     private int sum(TreeNode root) {
//         if(root == null)
//             return 0;
//         else
//             return root.val + sum(root.left) + sum(root.right);
//     }
}
