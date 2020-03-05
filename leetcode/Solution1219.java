package leetcode;

public class Solution1219 {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private int max = 0;
    private boolean[][] visited;

    public int getMaximumGold(int[][] grid) {
        final int row = grid.length, col = grid[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] >= 0) {
                    visited[i][j] = true;
                    dfs(grid, i, j, 0);
                    visited[i][j] = false;
                }
            }
        }
        return max;
    }

    private void dfs(final int[][] grid, int x, int y, int sum) {
        final int row = grid.length, col = grid[0].length;
        sum += grid[x][y];
        if(max < sum) {
            max = sum;
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if(verify(grid, xx, yy) && !visited[xx][yy] && grid[xx][yy] > 0) {
                visited[xx][yy] = true;
                dfs(grid, xx, yy, sum);
                visited[xx][yy] = false;
            }
        }
    }

    private static boolean verify(final int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
