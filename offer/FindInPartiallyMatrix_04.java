package offer;

public class FindInPartiallyMatrix_04 {
    public static boolean find(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while(row < m && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] > target) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 7;
        System.out.println(find(matrix, target));
    }
}
