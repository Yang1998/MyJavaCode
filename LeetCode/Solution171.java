package leetcode;

public class Solution171 {
    public int titleToNumber(String s) {
        final int OFFSET = (int)'A' - 1;
        int n = s.length();
        int ans = 0, pow = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            ans += (c - OFFSET) * pow;
            pow *= 26;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution171().titleToNumber("A"));
        System.out.println(new Solution171().titleToNumber("AB"));
        System.out.println(new Solution171().titleToNumber("ZY"));
    }
}
