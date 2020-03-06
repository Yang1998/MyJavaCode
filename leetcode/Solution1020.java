package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1020 {
    private static final int SUCCESS = -1;
    private static final int OCEAN = 0;
    private static final int LAND = 1;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private int cnt = 0;
    public int numEnclaves(int[][] A) {
        List<int[]> start = new ArrayList<>();
        final int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(A[i][j] == LAND) {
                    cnt++;
                    if(isEdge(row, col, i, j)) {
                        start.add(new int[]{i, j});
                    }
                }
            }
        }

        for (int[] ints : start) {
            int x = ints[0], y = ints[1];
            dfs(A, x, y);
        }

        return cnt;
    }

    private void dfs(int[][] grid, int x, int y) {
        if(grid[x][y] != LAND) {
            return;
        }
        final int row = grid.length, col = grid[0].length;
        grid[x][y] = SUCCESS;
        cnt--;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if(verify(row, col, xx, yy) && grid[xx][yy] == LAND) {
                dfs(grid, xx, yy);
            }
        }
    }

    private static boolean verify(int row, int col, int x, int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }
    private static boolean isEdge(int row, int col, int x, int y) {
        return x == 0 || x == row - 1 || y == 0 || y == col - 1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(new Solution1020().numEnclaves(arr));
    }
}
