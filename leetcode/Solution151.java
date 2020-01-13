package leetcode;

public class Solution151 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        if ("".equals(s.trim())) {
            return "";
        }
        int index = 0;
        s = s.trim();
        String res = "";
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                sb.append(s.charAt(index));
            } else {
                if (sb.length() != 0) {
                    res = sb.toString() + " " + res;
                    sb.delete(0, sb.length());
                }
            }
            index++;
        }
        if (sb.length() != 0) {
            res = sb.toString() + " " + res;
        }
        return res.substring(0, res.length() - 1);
    }
}
