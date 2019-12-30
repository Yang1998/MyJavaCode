package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution5296 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(null == root1) {
            dfs(root2);
            return res;
        }
        if(null == root2) {
            dfs(root1);
            return res;
        }
        dfs(root1);
        dfs(root2);
        Collections.sort(res);
        return res;
    }

    private void dfs(TreeNode root) {
        if(null != root.left) {
            dfs(root.left);
        }
        res.add(root.val);
        if(null != root.right) {
            dfs(root.right);
        }
    }
}
