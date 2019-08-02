package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> ints) {
        if(root == null)
            return;
        for(Node node : root.children) {
            helper(node, ints);
        }
        ints.add(root.val);
    }
}
