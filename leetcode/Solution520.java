package leetcode;

public class Solution520 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int upper = 0, lower = 0;
        for(int i = 0; i < n; ++i) {
            if(Character.isUpperCase(word.charAt(i))) {
                upper++;
            }
            else {
                lower++;
            }
        }
        return (upper == n && lower == 0) || (upper == 0 && lower == n) || (upper == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        System.out.println(new Solution520().detectCapitalUse("USA"));
    }
}
