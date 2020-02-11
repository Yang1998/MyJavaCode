package offer;

public class PrintMatrix_29 {
    public static void printMatrixClockwisely(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int row = matrix.length, column = matrix[0].length;
        int count = row * column;
        int left = 0, right = column - 1, up = 0, down = row - 1;
        while (count > 0) {
            for (int y = left; y <= right; y++) {
                count--;
                sb.append(matrix[up][y]).append(",");
            }
            up++;
            for (int x = up; x <= down; x++) {
                count--;
                sb.append(matrix[x][right]).append(",");
            }
            right--;
            for (int y = right; y >= left ; y--) {
                count--;
                sb.append(matrix[down][y]).append(",");
            }
            down--;
            for (int x = down; x >= up ; x--) {
                count--;
                sb.append(matrix[x][left]).append(",");
            }
            left++;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
