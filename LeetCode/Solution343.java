package leetcode;

import org.junit.Test;

public class Solution343 {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        else if(n == 3) return 2;
        int num3 = n / 3;
        int num2 = 0;
        n %= 3;
        if(n == 1) {
            num3 -= 1;
            num2 = 2;
        }else {
            num2 = n == 2 ? 1 : 0;
        }
        return (int)Math.pow(3, num3) * (int)Math.pow(2, num2);
    }


    @Test
    public void test() {
        System.out.println(integerBreak(8));
    }
}
