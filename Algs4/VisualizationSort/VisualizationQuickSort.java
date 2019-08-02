package Algs4.VisualizationSort;

import edu.princeton.cs.algs4.StdDraw;

import static Algs4.VisualizationSort.Draw.draw;

public class VisualizationQuickSort {
    public static void quickSort(double[] nums) throws InterruptedException {
        if(nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    private static void quickSort(double[] nums, int l, int r) throws InterruptedException {
        if (l < r) {
            int i = l, j = r;
            double num = nums[i];
            while (i < j) {
                while (i < j && num <= nums[j]) j--;
                nums[i] = nums[j];
                draw(nums);
                while (i < j && nums[i] <= num) i++;
                nums[j] = nums[i];
                draw(nums);
            }
            nums[i] = num;
            draw(nums);
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StdDraw.setCanvasSize(1000, 1000);
        int N = 100;
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Math.random();
        }
        quickSort(nums);
    }
}



