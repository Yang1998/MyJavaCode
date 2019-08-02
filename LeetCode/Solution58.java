package leetcode;

public class Solution58 {
    public int lengthofLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        String[] ss = s.split(" ");
        return ss.length == 0 ? 0 : ss[ss.length-1].length();
    }

    public static void main(String[] args) {
        String s = "a ";
        System.out.println(new Solution58().lengthofLastWord(s));
    }
}
