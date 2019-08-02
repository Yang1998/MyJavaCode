package Algs4.VisualizationSort;

import edu.princeton.cs.algs4.StdDraw;

import static Algs4.VisualizationSort.Draw.draw;

public class VisualizationInsertionSort {
    public static void insertSort(double[] nums) throws InterruptedException {
        if(nums == null || nums.length < 2) return;

        for (int i = 1; i < nums.length; i++) {
            int j;
            double num = nums[i];
            for (j = i; j > 0 && nums[j - 1] > nums[i]; j--) { }
            System.arraycopy(nums, j, nums, j + 1, i - j);
            nums[j] = num;
            draw(nums);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        StdDraw.setCanvasSize(1000, 1000);
        int N = 100;
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Math.random();
        }
        insertSort(nums);
    }
}
