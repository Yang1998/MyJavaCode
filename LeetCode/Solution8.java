package leetcode;

public class Solution8 {
    public int myAtoi(String str) {
        if(str == null || str.equals(""))
            return 0;
        boolean flag = false;
        int res = 0, idx = 0;
        while (idx < str.length() && Character.isSpaceChar(str.charAt(idx)))  idx++;
        if(idx == str.length())
            return 0;
        else if(str.charAt(idx) == '-') {
            flag = true;
            idx++;
        }
        else if(str.charAt(idx) == '+'){
            idx++;
        }
        if(idx >= str.length() || !Character.isDigit(str.charAt(idx)))
            return 0;
        while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
            if(!flag && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && (str.charAt(idx) - '0') > 7)) return Integer.MAX_VALUE;
            if(flag && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && (str.charAt(idx) - '0') > 8)) return Integer.MIN_VALUE;
            res = res * 10 + str.charAt(idx++) - '0';
        }
        return flag ? -res : res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi(".1"));
    }
}
