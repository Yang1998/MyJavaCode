package leetcode;

import java.util.Arrays;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        int index = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for(int i = index; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
