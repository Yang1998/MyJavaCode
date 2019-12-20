package leetcode;

public class Solution999 {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = x + 1; i < m; i++) {
            char c = board[i][y];
            if(c == 'B')
                break;
            else if(c == 'p') {
                res++;
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            char c = board[i][y];
            if(c == 'B')
                break;
            else if(c == 'p') {
                res++;
                break;
            }
        }
        for (int i = y + 1; i < n; i++) {
            char c = board[x][i];
            if(c == 'B')
                break;
            else if(c == 'p') {
                res++;
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            char c = board[x][i];
            if(c == 'B')
                break;
            else if(c == 'p') {
                res++;
                break;
            }
        }
        return res;
    }


}
