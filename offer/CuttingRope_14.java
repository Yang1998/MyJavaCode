package offer;

public class CuttingRope_14 {
    public static int maxProductAfterCutting_solution1(int length) {
        if(length < 2)
            return 0;
        else if(length == 2) {
            return 1;
        }
        else if(length == 3) {
            return 2;
        }

        int[] dp = new int[length + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;

        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int tmp = dp[i] * dp[i - j];
                if(max < tmp) max = tmp;
                dp[i] = max;
            }
        }

        max = dp[length];
        return max;
    }

    /**
     * 贪心算法：尽量把绳子剪成３，如果最后还剩下４，则减为两个２
     */
    public static int maxProductAfterCutting_solution2(int length) {
        if(length < 2)
            return 0;
        else if(length == 2)
            return 1;
        else if(length == 3)
            return 2;
        int three = length / 3;
        if(length - three * 3 == 1) {
            three--;
        }
        int two = (length - three * 3) / 2;
        return (int)Math.pow(3, three) + (int)Math.pow(2, two);
    }
}
