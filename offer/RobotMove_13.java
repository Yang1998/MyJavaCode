package offer;

public class RobotMove_13 {
    private static int cnt = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static int movingCount(int threshold, int rows, int cols) {
        if(threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[][] isVisited = new boolean[rows][cols];
        isVisited[0][0] = true;
        dfs(threshold, 0, 0, rows, cols, isVisited);
        return cnt;
    }

    private static void dfs(int threshold, int x, int y, int rows, int cols, boolean[][] isVisited) {
        cnt++;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(0 <= xx && xx < rows && 0 <= yy && yy < cols && !isVisited[xx][yy] && (getSum(xx) + getSum(yy) <= threshold)) {
                isVisited[xx][yy] = true;
                dfs(threshold, xx, yy, rows, cols, isVisited);
            }
        }
    }

    private static int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }
}
