package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
    private void helper(int[] candidates, int index, int target, int sum, List<Integer> sums) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> tmp = new ArrayList<>(sums);
            res.add(tmp);
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            sum += candidates[i];
            sums.add(candidates[i]);
            helper(candidates, i, target, sum, sums);
            sum -= candidates[i];
            sums.remove(sums.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, target,0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        int[] can = {2, 3, 6, 7};
        Solution39 s = new Solution39();
        s.combinationSum(can, 7);
        System.out.println(s.res.toString());
    }
}

