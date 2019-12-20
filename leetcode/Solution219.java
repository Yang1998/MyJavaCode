package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(k < set.size()) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
