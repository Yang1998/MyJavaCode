package leetcode;

public class Solution292 {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution292().canWinNim(7));
    }
}
