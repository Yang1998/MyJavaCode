package leetcode;
/**
 * 由中序遍历和后序遍历构建二叉树
 */

import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    private static Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int index = 0;
        for(int i : inorder) {
            map.put(i, index++);
        }
        int n = inorder.length;
        return helper(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode helper(int[] inorder, int ini, int inj, int[] postorder, int posti, int postj) {
        if(ini <= inj && posti <= postj) {
            int rootVal = postorder[postj];
            int idx = map.get(rootVal);
            int num = idx - ini;
            TreeNode root = new TreeNode(rootVal);
            root.left = helper(inorder, ini, ini + num - 1, postorder, posti, posti + num - 1);
            root.right = helper(inorder, ini + num + 1, inj, postorder, posti + num, postj - 1);
            return root;
        }
        return null;
    }
}
