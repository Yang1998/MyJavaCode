package leetcode;

public class Solution824 {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] ss = S.split(" ");
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            char c = Character.toLowerCase(s.charAt(0));
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append(s);
            }
            else{
                sb.append(s.substring(1));
                sb.append(s.charAt(0));
            }
            sb.append("ma");
            for(int j = 0; j < i + 1; ++j) {
                sb.append('a');
            }
            if(i < ss.length - 1)
                sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution824().toGoatLatin("I speak Goat Latin"));
    }


}
