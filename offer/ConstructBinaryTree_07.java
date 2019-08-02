package offer;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTree_07 {
    private static int[] preOrder;
    private static int[] inOrder;
    public TreeNode Construct(int[] preOrder, int[] inOrder) {
        this.preOrder = preOrder;
        this.inOrder = inOrder;
        int n = preOrder.length;
        return helper(0, n - 1, 0, n - 1);
    }

    private static TreeNode helper(int preL, int preR, int inL, int inR) {
        if(preL > preR || inL > inR)
            return null;
        else if(preL == preR || inL == inR)
            return new TreeNode(preOrder[preL]);

        int val = preOrder[preL];
        TreeNode root = new TreeNode(val);
        int i;
        for (i = inL; i <= inR; ++i) {
            if (inOrder[i] == val) {
                break;
            }
        }
        int idx = i > inR ? 0 : i - inL;
        root.left = helper(preL + 1, preL + idx, inL, inL + idx - 1);
        root.right = helper(preL + idx + 1, preR, inL + idx + 1, inR);
        return root;
    }

    static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            System.out.println("null");
            return;
        }
        else
            queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[]  in = {4, 7, 2, 1, 5, 3, 8, 6};
        ConstructBinaryTree_07 cbt = new ConstructBinaryTree_07();
        TreeNode Node = cbt.Construct(pre, in);
        printTree(Node);
    }
}
