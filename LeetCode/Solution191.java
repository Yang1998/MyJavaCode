package leetcode;

public class Solution191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution191().hammingWeight(3));
    }
}
