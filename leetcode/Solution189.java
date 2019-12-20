package leetcode;

public class Solution189 {
    /*
    [l, r)
     */
    private void reverse(int[] nums, int l, int r) {
        int n = r - l;
        for(int i = 0; i < n / 2; ++i) {
            int tmp = nums[i + l];
            nums[i + l] = nums[r - i - 1];
            nums[r - i - 1] = tmp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, n - k, n);
        reverse(nums, 0, n - k);
        reverse(nums, 0, n);
    }
}
