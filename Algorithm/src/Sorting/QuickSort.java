package Sorting;


import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] nums, int l, int r) {
        if(l < r) {
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot - 1);
        quickSort(nums, pivot + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] > tmp) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= tmp) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    public static void main(String[] args) {
        int max = 20;
        Random random = new Random();
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, max - 1);
        System.out.println(Arrays.toString(nums));
    }
}
