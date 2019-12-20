package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution934 {
    Queue<node> queue = new LinkedList<>();

    static class node {
        public int x, y;
        public int dis;

        public node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int shortestBridge(int[][] A) {
        int res = Integer.MAX_VALUE;
        int m = A.length;
        int n = A[0].length;
        tag:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    break tag;
                }
            }
        }
        int reverse = bfs(A);
        res = Math.min(res, reverse);
//            if(res == 1) return res;

//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(A[i]));
//        }
        return res;
    }

    private void dfs(int[][] A, int x, int y) {
        int m = A.length;
        int n = A[0].length;
        A[x][y] = 9;
        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (0 <= xx && xx < m && 0 <= yy && yy < n) {
                if (A[xx][yy] == 1) {
                    dfs(A, xx, yy);
                } else if (A[xx][yy] == 0) {
                    A[xx][yy] = 2;
                    queue.add(new node(xx, yy, 1));
                }
            }
        }
    }

    private int bfs(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int len = queue.size();
        while (!queue.isEmpty()) {
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(A[i]));
            }
            System.out.println();
            len = queue.size();
            for (int k = 0; k < len; k++) {
                node cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int xx = dx[i] + cur.x;
                    int yy = dy[i] + cur.y;
                    if (0 <= xx && xx < m && 0 <= yy && yy < n) {
                        if (A[xx][yy] == 1) {
                            return cur.dis;
                        } else if (A[xx][yy] == 0) {
                            A[xx][yy] = 2;
                            queue.add(new node(xx, yy, cur.dis + 1));
                        }
                    }
                }
            }

        }
        return Integer.MAX_VALUE;
    }

    @Test
    public void test() {
//        int[][] A = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
//        int[][] A = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
//        int[][] A = {{1,1,0,1,0,0,1,1,0,0},{0,1,1,1,1,1,1,1,0,0},{0,0,1,0,1,1,0,0,0,0},{0,0,0,1,1,0,1,1,0,0},{0,0,0,1,0,0,1,0,1,0},{0,0,0,0,1,1,1,1,1,1},{0,0,0,0,1,1,1,0,1,0},{0,0,0,0,1,1,1,1,1,0},{0,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,1,0,0,0}};
//        int[][] A = {{1,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int[][] A = {{1, 1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(shortestBridge(A));
    }
}
