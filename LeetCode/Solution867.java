package leetcode;

import java.util.Arrays;

public class Solution867 {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];

        for(int i = 0; i < A.length; ++i) {
            for(int j = 0; j < A[0].length; ++j) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}};
        A = new Solution867().transpose(A);
        for(int[] a : A)
            System.out.println(Arrays.toString(a));
    }
}
