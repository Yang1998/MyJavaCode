package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution1008 {
    public static List<Integer> res = new LinkedList<>();

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null)
            return null;
        return helper(preorder, 0, preorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if(left <= right) {
            TreeNode root = new TreeNode(preorder[left]);

            int index = left + 1;

            while(index <= right && preorder[index] < root.val)
                index++;

            root.left = helper(preorder, left + 1, index - 1);
            root.right = helper(preorder, index, right);
            return root;
        }
        return null;
    }

    private static List<Integer> preOrder(TreeNode root) {
        if(root == null)
            res.add(null);
        else {
            res.add(root.val);
            if(root.left != null || root.right != null) {
                preOrder(root.left);
                preOrder(root.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        System.out.println(preOrder(new Solution1008().bstFromPreorder(preorder)));
    }
}
