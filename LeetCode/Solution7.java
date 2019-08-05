package leetcode;

public class Solution7 {
    public int reverse(int x) {
        if(x == 0 || x == Integer.MIN_VALUE)
            return 0;
        boolean flag = x > 0;
        x = Math.abs(x);
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if(!flag && res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 8) return 0;
            res = res * 10 + pop;
        }
        if(!flag)
            return -res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(120));
        System.out.println(new Solution7().reverse(-123));
        System.out.println(new Solution7().reverse(123));
        System.out.println(new Solution7().reverse(-1111111118));
    }
}
