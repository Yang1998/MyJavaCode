package leetcode;

public class Solution371 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution371().getSum(-1, 5));
    }

}
