package Algs4.VisualizationSort;

import edu.princeton.cs.algs4.StdDraw;

import static Algs4.VisualizationSort.Draw.draw;

public class VisualizationSelectionSort {
    public static void selectionSort(double[] nums) throws InterruptedException {
        if (nums == null || nums.length < 2) return;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int MinIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[MinIndex] > nums[j]) MinIndex = j;
            }
            swap(nums, i, MinIndex);
            draw(nums);
        }
    }

    private static void swap(double[] nums, int i, int j) {
        double tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) throws InterruptedException {
        StdDraw.setCanvasSize(1000, 1000);
        int N = 100;
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Math.random();
        }
        selectionSort(nums);
    }
}
