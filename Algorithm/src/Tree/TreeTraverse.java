package Tree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTraverse {
    public static void preOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public static void inOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        inOrderRecursive(root.left);
        System.out.print(root.val + " ");
        inOrderRecursive(root.right);
    }

    public static void postOrderRecursive(TreeNode root) {
        if(root == null)
            return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrderIteration(TreeNode root) {
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            //if cur is not null, go left,print current value and push stack
            if(cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            // if current node is null, pop a node from stack,and cur point to right
            else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历迭代版本
     * @param root
     */
    public static void inOrderIteration(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
        System.out.println();
    }

    /**
     * 根节点被访问的前提是右子树尾空或者０右子树刚被访问过
     * 必须要记录上次访问过的节点０．．８
     * @param root
     */
    public static void postOrderIteration(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, pre = null;
        while (!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.peek();
                if(cur.right == null || cur.right == pre) {
                    stack.pop();
                    pre = cur;
                    System.out.print(cur.val + " ");
                    cur = null;
                }
                else {
                    cur = cur.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        preOrderRecursive(root);
        System.out.println();
        inOrderRecursive(root);
        System.out.println();
        postOrderRecursive(root);
        System.out.println();
        preOrderIteration(root);
        inOrderIteration(root);
        postOrderIteration(root);
    }
}
