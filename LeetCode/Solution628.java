package leetcode;

import java.util.Arrays;

public class Solution628 {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[0] * nums[1] * nums[2];
        return Math.max(a, b);
    }
}
