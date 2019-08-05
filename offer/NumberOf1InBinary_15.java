package offer;

public class NumberOf1InBinary_15 {
    public static int numberOfOne(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
