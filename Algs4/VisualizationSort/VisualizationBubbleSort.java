package Algs4.VisualizationSort;

import edu.princeton.cs.algs4.StdDraw;

import static Algs4.VisualizationSort.Draw.draw;

public class VisualizationBubbleSort {
    public static void bubbleSort(double[] nums) throws InterruptedException {
        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]) {
                    isSorted = false;
                    swap(nums, j + 1, j);
                    draw(nums);
                }
            }
            if(isSorted) return;
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
        bubbleSort(nums);
    }
}
