package leetcode;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null)
            return 0;
        int res = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if(preSum[j] - preSum[i] == k)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new Solution560().subarraySum(nums, 2));
    }
}
