package leetcode;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int tx = x;
        int reverse = 0;
        while (tx != 0) {
            int pop = tx % 10;
            tx /= 10;
            reverse = reverse * 10 + pop;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(171));
    }
}
