package leetcode;

public class Solution136 {
    public int singleNUmber(int[] nums) {
        int n = nums.length;
        int x = 0;
        for(int t : nums) {
            x ^= t;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new Solution136().singleNUmber(nums));
    }
}
