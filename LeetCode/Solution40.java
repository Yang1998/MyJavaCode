package leetcode;

import java.util.*;

public class Solution40 {
    //List<List<Integer>> res = new linkedList<>(new linkedList<>());
    Set<List<Integer>> res = new HashSet<>(new HashSet<>());
    private void helper(int[] candidates, int index, int target, int sum, List<Integer> sums, boolean[] visited) {
        if(sum > target)
            return;
        if(sum == target) {
            List<Integer> tmp = new LinkedList<>(sums);
//            Collections.sort(tmp);
            res.add(tmp);
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(!visited[i] && sum + candidates[i] <= target) {
                sum += candidates[i];
                sums.add(candidates[i]);
                visited[i] = true;
                helper(candidates, i, target, sum, sums, visited);
                sum -= candidates[i];
                sums.remove(sums.size()  - 1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new LinkedList<>();
        boolean[] vis = new boolean[candidates.length];
        Arrays.sort(candidates);
        helper(candidates, 0, target, 0, temp, vis);
        List<List<Integer>> ans = new LinkedList<>(new LinkedList<>(res));
        return ans;
    }

    public static void main(String[] args) {
        Solution40 s = new Solution40();
        int[] candidates = {10,1,2,7,6,1,5};
        s.combinationSum2(candidates, 8);
        System.out.println(s.res.toString());
    }
}
