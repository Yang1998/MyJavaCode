package leetcode;

import java.util.Arrays;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] += 1;
        int carry = 0;
        for (int i = n - 1; i >= 0; --i) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if(carry != 0) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, n);
            return newDigits;
        }
        return digits;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{9, 9, 9})));
    }
}
