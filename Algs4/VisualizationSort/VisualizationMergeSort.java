package Algs4.VisualizationSort;

import edu.princeton.cs.algs4.StdDraw;

import static Algs4.VisualizationSort.Draw.draw;

public class VisualizationMergeSort {

    public static void mergeSort(double[] nums) throws InterruptedException {
        if(nums == null || nums.length < 2) return;
        mergeSort(nums, 0, nums.length - 1);
    }
    private static void mergeSort(double[] nums, int l, int r) throws InterruptedException {
        if(l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
            draw(nums);
        }
    }

    private static void merge(double[] nums, int l, int mid, int r) throws InterruptedException {
        double[] copy = new double[r - l + 1];
        int index = 0;
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if(nums[i] <= nums[j]) copy[index++] = nums[i++];
            else copy[index++] = nums[j++];
        }
        if(i <= mid) System.arraycopy(nums, i, copy, index, mid - i + 1);
        if(j <= r) System.arraycopy(nums, j, copy, index, r - j + 1);
        System.arraycopy(copy, 0, nums, l, r - l + 1);
    }


    public static void main(String[] args) throws InterruptedException {
        StdDraw.setCanvasSize(1000, 1000);
        int N = 100;
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Math.random();
        }
        mergeSort(nums);
    }
}
