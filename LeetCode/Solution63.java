package leetcode;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else{
                    if(i == 0) {
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(j == 0) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

}
