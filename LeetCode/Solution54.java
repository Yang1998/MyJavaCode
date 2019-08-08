package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int num = m * n;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        while (res.size() < num) {
            for (int i = left; i <= right && res.size() < num; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down && res.size() < num; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && res.size() < num; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && res.size() < num; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }


    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
}
