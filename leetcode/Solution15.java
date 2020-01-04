package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution15 {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) {
            return res;
        }
        // 排序数组
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            // 假如nums[k] > 0 直接break, 因为nums[i] + nums[j] > 0 ,要保证nums[i] + nums[j] = -nums[k],
            // 而数组递增，且j > i > k
            if(nums[k] > 0) break;
            // 去重
            if(k > 0 && nums[k - 1] == nums[k]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int count = nums[i] + nums[j] + nums[k];
                if(count == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    // k不动， 改变i, j
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                } else if(count < 0){
                    // 小了， 右移i
                    while (i < j && nums[i] == nums[++i]);
                } else {
                    //大了， 左移j
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
