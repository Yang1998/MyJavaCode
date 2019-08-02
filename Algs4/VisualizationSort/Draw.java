package Algs4.VisualizationSort;

import edu.princeton.cs.algs4.StdDraw;

public class Draw {
    public static void draw(double[] nums) throws InterruptedException {
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            double x = i * 1.0 / n;
            double y = nums[i] / 2.0;
            double rw = 0.5 / n;
            double rh = nums[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdDraw.show();
        StdDraw.pause(15);
    }
}
