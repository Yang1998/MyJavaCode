package leetcode;

public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) {
            return 0;
        }
        else if(n == 1){
            return nums[0];
        }
        else if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        else
            return Math.max(helper(nums, 0, n - 1), helper(nums,1, n));
    }

    private int helper(int[] nums, int i, int j) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i], nums[i+1]);
        for(int k = i + 2; k < j; ++k) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
        }
        return dp[j - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(new Solution213().rob(nums));
    }
}
