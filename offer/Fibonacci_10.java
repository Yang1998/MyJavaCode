package offer;

public class Fibonacci_10 {
    public static long Fibonacci(int n) {
        if(n < 0)
            return -1;
        if(n < 2)
            return n;
        long prepre = 0;
        long pre = 1;
        long cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = prepre + pre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(50));
    }
}
