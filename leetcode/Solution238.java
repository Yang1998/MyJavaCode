package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 我的理解是，双指针头尾处理，每次更新index=i的左乘积和index=n-1-i的右乘积
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= left;
            left *= nums[i];
            res[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        return res;
    }


    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
