package leetcode;

public class Solution190 {
    public int reverseBits(int n) {
        return (int)Long.parseLong(helper(Integer.toBinaryString(n)).reverse().toString(), 2);
    }

    private StringBuilder helper(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0;i < 32 - n; ++i)
            sb.append('0');
        sb.append(s);
        return sb;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(-3));
        System.out.println(new Solution190().reverseBits(-3));
//        System.out.println();
    }
}
