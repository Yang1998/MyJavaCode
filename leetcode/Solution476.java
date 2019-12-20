package leetcode;

public class Solution476 {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length(); ++i) {
            sb.append(s.charAt(i) == '1' ? 0 : 1);
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution476().findComplement(1));
    }
}
