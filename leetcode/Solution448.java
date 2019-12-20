package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]) {
                i++;
            }
            else {
                swap(nums, i, nums[i] - 1);
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1 ) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        if(nums[i] != nums[j]) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution448().findDisappearedNumbers(nums));
        System.out.println(Arrays.toString(nums));
    }
}
