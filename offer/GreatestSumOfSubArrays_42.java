package offer;

public class GreatestSumOfSubArrays_42 {
    public static int findGreatestSumOfSubArrays(int[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("输入有误！");
        }
        int[] dp = new int[array.length];
        int res = array[0];
        for (int i = 0; i < array.length; i++) {
            if(i != 0 && dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
            }
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
