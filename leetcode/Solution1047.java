package leetcode;
import java.util.Stack;
public class Solution1047 {
    public String removeDuplicates(String S) {
        if(S == null || S.length() <= 1)
            return S;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); ++i) {
            if(!stack.isEmpty() && S.charAt(i) == stack.peek()) {
                stack.pop();
            }
            else {
                stack.push(S.charAt(i));
            }
        }
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1047().removeDuplicates("abbaca"));
    }
}
