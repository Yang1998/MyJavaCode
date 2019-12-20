package leetcode;

public class Solution733 {
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] isVisited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, image[sr][sc], newColor, isVisited);
        return image;
    }


    private void helper(int[][] image, int sr, int sc, int Color, int newColor, boolean[][] isVisited) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == Color && !isVisited[sr][sc]) {
            image[sr][sc] = newColor;
            for(int k = 0; k < 4; ++k) {
                int x = dx[k] + sr;
                int y = dy[k] + sc;
                if(0 <= x && x < m && 0 <= y && y < n) {
                    helper(image, x, y, Color, newColor, isVisited);
                }
            }
        }
    }
}
