package leetcode;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        return sum < S || (sum + S) % 2 > 0 ? 0 : helper(nums, (sum + S) / 2);
    }
    private int helper(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = sum; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        return dp[sum];
    }
}
