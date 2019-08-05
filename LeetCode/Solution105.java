package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    private static Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx = 0;
        for(int i : inorder) {
            map.put(i, idx++);
        }
        int n = preorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);

    }

    private TreeNode helper(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj){
        if(prei <= prej && ini <= inj) {
            int rootVal = preorder[prei];
            int idx = map.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            int num = idx - ini;
            root.left = helper(preorder, prei + 1, prei + num - 1, inorder, ini, ini + num - 1);
            root.right = helper(preorder, prei + num, prej, inorder,idx + 1, inj);
        }
        return null;
    }
}
