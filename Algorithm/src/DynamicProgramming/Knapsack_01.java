package DynamicProgramming;

import java.util.Scanner;

public class Knapsack_01 {

    /**
     * 01背包问题
     * 从给定物品中挑选总重量不超过Ｗ的物品，求所有挑选方案中价值总和的最大值
     * data set:
     * n = 4
     * W = 5
     * (w, v) = {(2, 3), (1, 2), (3, 4), (2, 2)}
     * ans = 7
     * pick 0, 1, 3
     */

    static int n, W;
    static int[] w, v;

    public static int solve() {
        int max = -1;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j - w[i]] + v[i], dp[j]);
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        W = Integer.parseInt(scanner.nextLine());
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println(solve());
    }
}
