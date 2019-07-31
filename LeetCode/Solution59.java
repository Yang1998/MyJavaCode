package leetcode;

import java.util.Arrays;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int N = n * n;
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (num <= N) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left ; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top ; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] res = new Solution59().generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
