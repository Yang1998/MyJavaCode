package leetcode;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        boolean flag = false;
        boolean col = false;
        boolean row = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0 && j == 0) {
                        flag = true;
                        continue;
                    }
                    else if(i != 0 && j == 0) {
                        col = true;
                    }
                    else if(i == 0 && j != 0) {
                        row = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if(matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if(row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(col) {
            for(int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }

        if(flag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
