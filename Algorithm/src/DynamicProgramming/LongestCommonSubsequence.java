package DynamicProgramming;

public class LongestCommonSubsequence {
    public static int LCS(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = s.charAt(i) == t.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(LCS("abcd", "becd"));
    }
}
