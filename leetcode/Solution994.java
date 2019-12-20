package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    Queue<int[]> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        if (queue.size() == 0) return -1;
        while (fresh > 0) {
            int size = queue.size();
            int tmp = fresh;
            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i], yy = y + dy[i];
                    if (0 <= xx && xx < m && 0 <= yy && yy < n && grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        queue.add(new int[]{xx, yy});
                        fresh--;
                    }
                }
            }
            res++;
            if(fresh == tmp) return -1;
        }
        return res;
    }


    @Test
    public void test(){
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = {{0,2}};
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid));
    }
}
