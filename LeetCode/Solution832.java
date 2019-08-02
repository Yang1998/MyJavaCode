package leetcode;

import java.util.Arrays;

public class Solution832 {
    public int[][] filpAndInvertImage(int[][] A) {
        if(A == null || A.length == 0)
            return A;
        int m = A.length;
        int n = A[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < (n + 1) >> 1; ++j) {
                if(A[i][j] == A[i][n - j - 1]) {
                    A[i][j] ^= 1;
                    A[i][n - j - 1] = A[i][j];
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        new Solution832().filpAndInvertImage(arr);
        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
