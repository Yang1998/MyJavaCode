package leetcode;

public class Solution125 {
    public boolean isPalindrome(String s) {
        if(s.equals(""))
            return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else if(Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int n = sb.length();
        for (int i = 0; i < n / 2; i++) {
            if(sb.charAt(i) != sb.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
