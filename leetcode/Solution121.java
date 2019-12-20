package leetcode;

/**
 * 动态规划
 * 1.dp[i] = max{dp[i - 1], prices[i] - min}, min 是prices在0~i-1序号中的最小值
 */
public class Solution121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        int[] ints = new int[]{7,6,4,3,1};
        System.out.println(s.maxProfit(ints));
    }

     public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n];

        dp[0] = 0;
        int min = prices[0];
        for(int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            if(prices[i] < min) {
                min = prices[i];
            }
        }
        return dp[n - 1];
     }
}
