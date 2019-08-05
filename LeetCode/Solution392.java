package leetcode;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if(i < s.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution392().isSubsequence("abc", "arcbperc6398902386890329690234642569562490569724906790426904756979340764"));
    }
}
