package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    private boolean[] isVisited;
    private List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        isVisited = new boolean[n];
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, n, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, int n, List<Integer> cur) {
        if(index == n) {
            List<Integer> tmp = new ArrayList<>(cur);
            res.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                if(i != 0 && nums[i - 1] == nums[i] && !isVisited[i - 1]) {
                    continue;
                }
                cur.add(nums[i]);
                isVisited[i] = true;
                dfs(nums, index + 1, n, cur);
                isVisited[i] = false;
                cur.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Solution47().permuteUnique(nums));
    }
}
