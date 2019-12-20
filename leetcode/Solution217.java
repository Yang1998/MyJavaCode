package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        return set.size() != nums.length;
    }
}
