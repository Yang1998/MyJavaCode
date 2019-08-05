package leetcode;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示i元最少需要dp[i]个硬币，当dp[i]等于amount+1时，表示给定coins无解
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
