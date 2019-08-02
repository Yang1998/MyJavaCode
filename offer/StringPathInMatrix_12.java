package offer;

public class StringPathInMatrix_12 {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    static boolean res = false;
    private static boolean[][] isVisited;
    public static boolean hasPath(char[][] matrix, String str) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1 || str == null)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == str.charAt(0)) {
                    isVisited[i][j] = true;
                    dfs(matrix, i, j, 0, str);
                    isVisited[i][j] = false;
                }
            }
        }
        return res;
    }


    private static void dfs(char[][] matrix, int x, int y, int index, String str) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(index == str.length()) {
            res = true;
            return;
        }
        if(matrix[x][y] != str.charAt(index)) return;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(0 <= xx && xx < n && 0 <= yy && yy < m && !isVisited[xx][yy]) {
                isVisited[xx][yy] = true;
                dfs(matrix, xx, yy, index + 1, str);
                isVisited[xx][yy] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(hasPath(matrix, "bfca"));
    }
}
