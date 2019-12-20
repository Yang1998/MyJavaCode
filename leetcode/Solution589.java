package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution589 {
    public List<Integer> preorder(Node node) {
        List<Integer> res = new LinkedList<>();
        helper(node, res);
        return res;
    }
    private void helper(Node root, List<Integer> ints) {
        if(root == null)
            return;
        ints.add(root.val);
        for(Node node : root.children) {
            helper(node, ints);
        }
    }
}
