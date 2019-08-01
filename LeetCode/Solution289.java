package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Solution289 {
    public void gameOfLife(int[][] board) {
        HashSet<int[]> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int flag = check(board, i, j);
                if(flag != 0) set.add(new int[]{i, j});
            }
        }

        for(int[] entry : set) {
            int x = entry[0];
            int y = entry[1];
            int num = board[x][y];
            if(num == 1) board[x][y] = 0;
            else board[x][y] = 1;
        }
    }

    public int check(int[][] board, int x, int y) {
        int cnt = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;
                int xx = x + i;
                int yy = y + j;
                if(0 <= xx && xx < board.length && 0 <= yy && yy < board[0].length && board[xx][yy] == 1) {
                    cnt++;
                }
            }
        }
        if(board[x][y] == 0) {
            if(cnt == 3) return 1; // dead -> alive
        }
        else {
            if(cnt < 2) return -1;
            else if(cnt > 3) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] board = {{1, 1}};
        new Solution289().gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
