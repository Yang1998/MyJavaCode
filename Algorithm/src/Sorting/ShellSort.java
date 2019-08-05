package Sorting;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    public static void shellSort(int[] nums, int N) {
        if(nums == null || nums.length < 2)
            return;
        int n = nums.length, i, j;
        for (int Increment = N >> 1; Increment > 0; Increment >>= 1) {
            for (i = Increment; i < n; i++) {
                int tmp = nums[i];
                for (j = i; j >= Increment ; j -= Increment) {
                    if(tmp < nums[j - Increment]) {
                        nums[j] = nums[j - Increment];
                    }
                    else {
                        break;
                    }
                }
                nums[j] = tmp;
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
        shellSort(nums, 8);
        System.out.println(Arrays.toString(nums));
    }
}
