package leetcode;

public class Solution718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int ans = -1;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(new Solution718().findLength(A, B));
    }
}
