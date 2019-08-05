package leetcode;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }
        int res = dp[0];
        for (int i = 0; i < nums.length; i++) {
            if(res < dp[i])
                res = dp[i];
        }
        return res;
    }
}
