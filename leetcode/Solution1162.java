package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1162 {
    private static final int LAND = 1;
    private static final int OCEAN = 0;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final int len = dx.length;
    public int maxDistance(int[][] grid) {
        int cnt = 0;
        int dis = 0;
        final int row = grid.length, col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == LAND) {
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == OCEAN) {
                    cnt++;
                }
            }
        }
        // 如果全是海洋或者全是陆地，直接返回0
        if(cnt == 0 || cnt == row * col) {
            return -1;
        }
        while (cnt > 0) {
            dis++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] ints = queue.poll();
                for (int index = 0; index < len; index++) {
                    int x = ints[0] + dx[index], y = ints[1] + dy[index];
                    if(0 <= x && x < row && 0 <= y && y < col && grid[x][y] == OCEAN) {
                        queue.add(new int[]{x, y});
                        cnt--;
                        grid[x][y] = LAND;
                    }
                }
            }
        }
        return dis;
    }
}
