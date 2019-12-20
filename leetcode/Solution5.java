package leetcode;

public class Solution5 {
    public String longestPalindrome(String s) {
        if(s ==null || s.length() < 2)
            return s;
        int n = s.length();
        int max = -1;
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if(i < n - 1) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = true;
                    start = i;
                    end = i + 1;
                }
            }
        }

        for(int L = 3; L <= n; ++L) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution5().longestPalindrome(s));
    }
}
