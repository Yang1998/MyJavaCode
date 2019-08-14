package leetcode;

import org.junit.Test;

public class Solution79 {
    private static boolean[][] isVisited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean flag = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(word == null || word.length() == 0 || word.length() > m * n) return false;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(word.length() == 1) return true;
                    isVisited[i][j] = true;
                    dfs(board, word, 1, i, j);
                    isVisited[i][j] = false;
                    if(flag){
                        flag = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void dfs(char[][] board, String word, int index,int x, int y) {
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if(!flag && 0 <= xx && xx < board.length && 0 <= yy && yy < board[0].length && !isVisited[xx][yy] && board[xx][yy] == word.charAt(index)) {
                if(index + 1 == word.length()) {
                    flag = true;
                    return;
                }
                isVisited[xx][yy] = true;
                dfs(board, word, index + 1, xx, yy);
                isVisited[xx][yy] = false;
            }
        }
    }


    @Test
    public void test() {
//        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";
//        String word = "ABCCEB";

        char[][] board = {{'A','B'}, {'C', 'D'}};
        String word = "ABCD";
        System.out.println(exist(board, word));
    }
}
