package leetcode;

import java.util.Arrays;

public class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        helper(board, click[0], click[1]);
        return board;
    }

    private void helper(char[][] board, int X, int Y) {
        int m = board.length;
        int n = board[0].length;
        if(board[X][Y] == 'E') {
            int cnt = count(board, X, Y);
            if(cnt == 0) {
                board[X][Y] = 'B';
                for(int x = X - 1; x <= X + 1; ++x) {
                    for(int y = Y - 1; y <= Y + 1; ++y) {
                        if(0 <= x && x < m && 0 <= y && y < n) {
                            helper(board, x, y);
                        }
                    }
                }
            }
            else {
                board[X][Y] = (char)('0' + cnt);
            }

        }
    }

    private int count(char[][] board, int x, int y) {
        int res = 0;
        for(int i = x - 1; i <= x + 1; ++i) {
            for(int j = y - 1; j <= y + 1; ++j) {
                if(0 <= i && i < board.length && 0 <= j && j < board[0].length) {
                    if(board[i][j] == 'M') {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    private void print(char[][] arr) {
        for(char[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        }; // [3, 0]

//        char[][] board = {
//                {'B', '1', 'E', '1', 'B'},
//                {'B', '1', 'M', '1', 'B'},
//                {'B', '1', '1', '1', 'B'},
//                {'B', 'B', 'B', 'B', 'B'}
//        }; //[1, 2]

//        char[][] board = {
//                {'E','E','E','E','E','E','E','E'},
//                {'E','E','E','E','E','E','E','M'},
//                {'E','E','M','E','E','E','E','M'},
//                {'M','E','E','E','E','E','E','E'},
//                {'E','E','E','E','E','E','E','E'},
//                {'E','E','E','E','E','E','E','E'},
//                {'E','E','E','E','E','E','E','E'},
//                {'E','E','M','M','E','E','E','E'},
//        };     //[0, 0]
        Solution529 s = new Solution529();
        s.updateBoard(board, new int[]{3, 0});
        s.print(board);

    }
}
/*
[
["E","E","E","E","E","E","E","E"],
["E","E","E","E","E","E","E","M"],
["E","E","M","E","E","E","E","E"],
["M","E","E","E","E","E","E","E"],
["E","E","E","E","E","E","E","E"],
["E","E","E","E","E","E","E","E"],
["E","E","E","E","E","E","E","E"],
["E","E","M","M","E","E","E","E"]]
[0,0]
 */

/*
[["B","B","B","B","B","B","1","E"],
["B","1","1","1","B","B","1","M"],
["1","2","M","1","B","B","1","1"],
["M","2","1","1","B","B","B","B"],
["1","1","B","B","B","B","B","B"],
["B","B","B","B","B","B","B","B"],
["B","1","2","2","1","B","B","B"],
["B","1","M","M","1","B","B","B"]]
[0,7]
 */