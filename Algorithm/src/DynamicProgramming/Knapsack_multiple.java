package DynamicProgramming;

import java.util.Scanner;

public class Knapsack_multiple {
    private static int n;
    private static int W;
    private static int[] w, v;

    public static int solve(){
        int[] dp = new int[W + 1];
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                max = Math.max(dp[j], max);
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
