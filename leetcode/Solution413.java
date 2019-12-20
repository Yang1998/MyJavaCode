package leetcode;
/*
if A[j] - A[j-1] == A[i+1] - A[i]
than judge j - i
if j - i == 2
dp[i][j] = true
else
dp[i][j] = dp[i][j-1]
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3) {
            return 0;
        }
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int L = 2; L <= n; ++L) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if(A[i + 1] - A[i] == A[j] - A[j - 1]) {
                    if(j - i == 2) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
                res += dp[i][j] ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution413().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
