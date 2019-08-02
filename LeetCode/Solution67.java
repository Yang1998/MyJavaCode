package leetcode;

public class Solution67 {
    public String addBinary(String a, String b) {
        int maxlen = Math.max(a.length(), b.length());
        int minlen = Math.min(a.length(), b.length());
        int i;
        StringBuilder sba = new StringBuilder(a).reverse();
        StringBuilder sbb = new StringBuilder(b).reverse();
        StringBuilder sb = new StringBuilder();
        int[] ints = new int[maxlen];
        for (i = 0; i < minlen; i++) {
            ints[i] = ((sba.charAt(i) - '0') + (sbb.charAt(i) - '0'));
        }
        for(; i < a.length(); ++i)
            ints[i] = (sba.charAt(i) - '0');
        for(; i < b.length(); ++i)
            ints[i] = (sbb.charAt(i) - '0');
        for (i = 0; i < maxlen - 1; i++) {
            if(ints[i] > 1) {
                ints[i + 1] += (ints[i] >> 1);
                ints[i] %= 2;
            }
        }
        boolean flag = false;
        if(ints[maxlen - 1] > 1) {
            flag = true;
            ints[maxlen - 1] %= 2;
        }
        for (i = 0; i < maxlen; i++) {
            sb.append(ints[i]);
        }
        if(flag)
            sb.append(1);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution67().addBinary("0000000000000000000000000000000100000000000000000000000000000000"
                ,"1111111111111111111111111111111111001010111111101011101010111110"));

    }
}
