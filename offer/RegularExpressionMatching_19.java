package offer;

public class RegularExpressionMatching_19 {
    public static boolean match(String str, String pattern) {
        if(str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern);
    }

    private static boolean matchCore(String str, String pattern) {
        if(str.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if(str.length() != 0 && pattern.length() == 0) {
            return false;
        }
        if(pattern.length() > 1 && pattern.charAt(1) == '*') {
            if(pattern.charAt(0) == str.charAt(0) || (pattern.charAt(0) == '.' && str.length() > 1)) {
                return matchCore(str.substring(1), pattern.substring(2)) || matchCore(str.substring(1), pattern) || matchCore(str, pattern.substring(2));
            } else {
                return matchCore(str, pattern.substring(2));
            }
        }
        if(str.charAt(0) == pattern.charAt(0) || (pattern.charAt(0) == '.' && str.length() > 1)) {
            return matchCore(str.substring(1), pattern.substring(1));
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(match("baa", "b*a"));
    }
}
