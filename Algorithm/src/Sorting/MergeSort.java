package Sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] nums) {
        if(nums == null || nums.length < 2)
            return;

        mergeSort(nums, 0, nums.length - 1);

    }

    private static void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            int mid = l + ((r - l) >> 1);
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int cur = 0;
        int[] newArray = new int[r - l + 1];
        int left = l, right = mid + 1;
        while (left <= mid && right <= r) {
            if(nums[left] <= nums[right])
                newArray[cur++] = nums[left++];
            else
                newArray[cur++] = nums[right++];
        }
        if(left <= mid)
            System.arraycopy(nums, left, newArray, cur, mid - left + 1);
        if(right <= r)
            System.arraycopy(nums, right, newArray, cur, r - right + 1);
        System.arraycopy(newArray, 0, nums, l, newArray.length);
    }


    public static void main(String[] args) {
        int max = 10;
        Random random = new Random();
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
