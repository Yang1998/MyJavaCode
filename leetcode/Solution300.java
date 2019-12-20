package leetcode;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; ++j) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = null;
        System.out.println(new Solution300().lengthOfLIS(nums));
    }
}
