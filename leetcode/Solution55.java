package leetcode;

public class Solution55 {
    public boolean canJump(int[] nums) {
        if(nums == null)
            return false;
        return jump(nums, 0);
    }
    private boolean jump(int[] nums, int from) {
        int n = nums[from];
        for (int i = from; n >= 0 ; i++) {
            if(i >= nums.length - 1) {
                return true;
            }
            if(n < nums[i]) {
                return jump(nums, i);
            }
            --n;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {0};
        System.out.println(new Solution55().canJump(nums));
    }
}
