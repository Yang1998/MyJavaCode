package leetcode;

import org.junit.Test;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int imax = 1, imin = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            res = Math.max(imax, res);
        }
        return res;
    }

    @Test
    public void test() {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-1, -2, -5, -9};
        System.out.println(maxProduct(nums));
    }
}
