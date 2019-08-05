package Sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    public static void insertSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;
        int tmp;
        for (int i = 1; i < n; i++) {
            tmp = nums[i];
            int j;
            for (j = i; j > 0 && nums[j - 1] > tmp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
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
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
