package leetcode;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[1] = 10;
        for(int i = 2; i <= n; ++i)
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - i + 1);
        return dp[n];
    }
}
