package leetcode;

public class Solution342 {
    public boolean isPowerOfFour(int num){
        if(num < 0 || (num & (num - 1)) != 0) {
            return false;
        }
        return (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution342().isPowerOfFour(16));
    }
}
