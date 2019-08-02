package leetcode;

import java.util.Arrays;

public class Solution344 {
    public void reverseString(char[] s) {
        if(s == null || s.length < 2) {
            return;
        }

        int n = s.length;
        int cnt = n >> 1;
        for(int i = 0; i < cnt; ++i) {
            char tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};

        new Solution344().reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
