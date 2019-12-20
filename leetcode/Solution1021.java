package leetcode;

public class Solution1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int cur = 0;
        int idx = 0;
        while(cur < S.length()) {
            if(S.charAt(cur) == '(') {
                idx++;
            }
            else {
                idx--;
            }

            if(idx == 0) {
                sb.append(S.substring(start + 1, cur));
                start = cur + 1;
            }
            cur++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()()())(())";
        System.out.println(new Solution1021().removeOuterParentheses(s));
    }
}
