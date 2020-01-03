package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution216 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> tmp = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

    private void dfs(int k, int n, int index) {
        if(n < 0 || tmp.size() > k) return;
        if(n == 0 && tmp.size() == k) {
            res.add(new LinkedList<>(tmp));
        } else {
            for (int i = index; i <= 9; i++) {
                tmp.add(i);
                dfs(k, n - i, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Solution216 s = new Solution216();
        System.out.println(s.combinationSum3(3, 7));
    }
}
