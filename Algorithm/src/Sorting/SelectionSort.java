package Sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void selectionSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
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
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
