package Sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    public static void bubbleSort(int[] nums) {
        if(nums == null || nums.length < 2)
            return;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted) return;
        }
    }


    public static void main(String[] args) {
        int max = 20;
        Random random = new Random();
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
