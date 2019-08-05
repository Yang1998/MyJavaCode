package leetcode;

public class Solution709 {
    public String ToLowerCase(String str) {
        if(str == null)
            return str;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); ++i) {
            if(65 <= str.charAt(i) && str.charAt(i) <= 90)
                sb.append((char)(str.charAt(i) + 32));
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(new Solution709().ToLowerCase(s));
    }
}
