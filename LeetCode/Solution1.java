package leetcode;

import java.util.*;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i : nums) {
            map.put(i, idx++);
        }
        for(int i = 0; i < nums.length; ++i) {
            int j = target - nums[i];
            Integer flag = map.get(j);
            if(flag != null && i != flag) {
                return new int[]{i, flag};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution1().twoSum(nums, target)));

    }
}
