package leetcode;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i < n - 1) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                }
            }
        }

        for(int L = 2; L <= n; ++L) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
