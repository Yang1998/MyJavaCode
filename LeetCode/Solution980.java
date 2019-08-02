package leetcode;

public class Solution980 {
    int res = 0;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    int M, N;
    int[] start;
    int[] end;
    public int uniquePathsIII(int[][] grid) {
        int cnt = 0;
        M = grid.length;
        N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 0)
                    cnt++;
                else if(grid[i][j] == 1)
                    start = new int[]{i, j};
                else if(grid[i][j] == 2)
                    end = new int[]{i, j};
            }
        }
        dfs(grid, cnt, start[0], start[1]);
        return res;
    }


    void dfs(int[][] grid, int cnt, int X, int Y) {
        if(X == end[0] && Y == end[1]) {
            if(cnt == 0) {
                res++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = X + dx[i], y = Y + dy[i];
            if(0 <= x && x < M && 0 <= y && y < N) {
                if(grid[x][y] == 0){
                    grid[x][y] = -2;
                    dfs(grid, cnt - 1, x, y);
                    grid[x][y] = 0;
                }
                else if(grid[x][y] == 2) {
                    dfs(grid, cnt, x, y);
                }
            }
        }
    }


    public static void main(String[] args) {
//        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
//        int[][] grid = {{0,1},{2,0}};
        System.out.println(new Solution980().uniquePathsIII(grid));
    }
}
