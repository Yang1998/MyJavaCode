package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution653 {
    List<Integer> res = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int i = 0, j = res.size() - 1;
        while(i < j) {
            int num = res.get(i) + res.get(j);
            if(num > k)
                j--;
            else if(num < k)
                i++;
            else
                return true;
        }
        return false;
    }

    private void inOrder(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null) {
            inOrder(root.left);
        }
        res.add(root.val);
        if(root.right != null) {
            inOrder(root.right);
        }
    }
}
