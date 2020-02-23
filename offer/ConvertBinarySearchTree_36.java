package offer;

public class ConvertBinarySearchTree_36 {
    private TreeNode pre, head, tail;
    public TreeNode convert(TreeNode root) {
        if(root == null) {
            return null;
        }
        inOrder(root);
        // 连接首尾
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        // 如果pre为null，则说明是第一次给pre赋值
        if(pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        // 更新pre, tail
        pre = root;
        tail = root;
        inOrder(root.right);
    }
}
