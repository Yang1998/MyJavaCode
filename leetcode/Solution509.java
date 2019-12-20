package leetcode;

public class Solution509 {
    public int fib(int N) {
        if(N < 2) {
            return N;
        }
        int a = 0, b = 1;
        for(int i = 2; i <= N; ++i) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution509().fib(4));
    }
}
