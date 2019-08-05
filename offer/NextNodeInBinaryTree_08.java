package offer;

public class NextNodeInBinaryTree_08 {
    private class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode (int val, TreeNode patent) {
            this.val    = val;
            this.parent = patent;
        }
    }

    public static TreeNode getNext(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode next = null;
        if(root.right != null) {
            next = root.right;
            while(next.left != null) {
                next = next.left;
            }
        }
        else if(root.parent != null) {
            TreeNode parent = root.parent;
            TreeNode cur    = root;
            while(parent != null && parent.right == cur) {
                cur = parent;
                parent = cur.parent;
            }
            next = parent;
        }
        return next;
    }
}
