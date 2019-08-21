package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if(i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int index) {
        int n = (nums.length - index) / 2;
        for (int i = 0; i < n; i++) {
            swap(nums, index + i, nums.length - 1 - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    @Test
    public void test() {
        int[] nums = {9, 5, 4, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
