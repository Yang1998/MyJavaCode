package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>(new LinkedList<>());
        helper(root, res);
        return res;
    }
    private void helper(Node root, List<List<Integer>> intss) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < n; ++i) {
                Node node = queue.poll();
                tmp.add(node.val);
                for(Node node1 : node.children) {
                    queue.add(node1);
                }
            }
            intss.add(tmp);
        }
    }
}
