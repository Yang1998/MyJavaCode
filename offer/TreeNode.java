package offer;

public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode (TreeNode head) {
        this.val = head.val;
        this.left = head.left;
        this.right = head.right;
    }
}
