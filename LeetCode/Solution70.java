package leetcode;

public class Solution70 {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int ans = 0;
        int prepre = 1, pre = 2;
        for (int i = 3; i <= n; i++) {
            ans = prepre + pre;
            prepre = pre;
            pre = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(4));
    }
}
