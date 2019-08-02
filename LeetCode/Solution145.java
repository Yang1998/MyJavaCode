package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.peek();
                if(cur.right == null || cur.right == pre) {
                    res.add(cur.val);
                    pre = cur;
                    stack.pop();
                    cur = null;
                }
                else {
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
