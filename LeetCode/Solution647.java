package leetcode;

public class Solution647 {
    public int countSubstrings(String s) {
        if(s == null)
            return 0;
        int n = s.length();
        int cnt = n;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1] == 1)) {
                    dp[i][j] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution647().countSubstrings("aaaaa"));
    }
}
