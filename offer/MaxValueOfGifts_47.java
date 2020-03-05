package offer;

public class MaxValueOfGifts_47 {
    public int getMaxValue(final int[][] values) {
        if(values == null || values.length == 0) {
            return 0;
        }
        int row = values.length;
        int column = values[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int left = 0;
                int up = 0;
                if(i > 0) {
                    up = dp[i - 1][j];
                }
                if(j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.max(up, left) + values[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }
}
