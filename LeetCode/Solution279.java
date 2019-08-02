package leetcode;

public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for(int i = 0; i <= n; ++i) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(13));
    }
}
