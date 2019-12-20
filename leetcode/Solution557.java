package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            }
            else{
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution557().reverseWords("Let's take LeetCode contest"));
    }
}
