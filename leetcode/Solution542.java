package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0) {
                    bfs(matrix, i, j);
                }
            }
        }
        return matrix;
    }


    private void bfs(int[][] matrix, int x, int y) {
        int depth = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int xx = cur[0] + dx[k], yy = cur[1] + dy[k];
                    if(0 <= xx && xx < matrix.length && 0 <= yy && yy < matrix[0].length) {
                        if(matrix[xx][yy] == 0) {
                            matrix[x][y] = depth + 1;
                            return;
                        }
                        queue.add(new int[]{xx, yy});
                    }
                }
            }
                depth++;
        }
    }


    @Test
    public void test() {
//        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] matrix = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
