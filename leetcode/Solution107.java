package leetcode;


import java.util.*;

/**
 * 层序遍历， 然后反转
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            while(n-- > 0) {
                TreeNode r1 = queue.poll();
                if(r1.left != null)
                    queue.add(r1.left);
                if(r1.right != null)
                    queue.add(r1.right);
                tmp.add(r1.val);
            }
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;
    }
}
