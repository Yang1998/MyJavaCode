package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution230 {
    private int ans;
    private int cnt;
    private TreeNode createTree(Integer[] vals) {
        TreeNode root = new TreeNode(vals[0]);
        TreeNode pre = root;
        int index = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && index < vals.length) {
            TreeNode tmp = q.poll();
            if(index < vals.length && vals[index] != null) {
                tmp.left = new TreeNode(vals[index]);
                q.offer(tmp.left);
                index++;
            }
            if(index < vals.length && vals[index] != null) {
                tmp.right = new TreeNode(vals[index]);
                q.offer(tmp.right);
                index++;
            }
        }
        return root;
    }
    private void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.left);
        cnt--;
        if(cnt == 0) {
            ans = root.val;
            return;
        }
        helper(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        helper(root);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,4,null,2};
        Solution230 s = new Solution230();
        TreeNode root = s.createTree(arr);
        System.out.println(s.kthSmallest(root, 1));
    }
}
