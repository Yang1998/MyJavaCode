package leetcode;

public class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n >= 5) {
            res += (n /= 5);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution172().trailingZeroes(125));
    }
}
