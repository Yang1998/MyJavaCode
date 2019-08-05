package leetcode;
/**
 * 两种方法，递归和迭代,类似144,155
 */


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
//    List<Integer> res = new linkedList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null)
//            return res;
//
//        inorderTraversal(root.left);
//        res.add(root.val);
//        inorderTraversal(root.right);
//        return res;
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }

        }
        return res;
    }

}
