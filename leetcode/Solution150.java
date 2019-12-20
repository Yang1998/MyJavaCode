package leetcode;
import org.junit.Test;

import java.util.Stack;

public class Solution150 {
    private static String[] oper = {"+", "-", "*", "/"};
    private static boolean isOper(String s) {
        for (int i = 0; i < oper.length; i++) {
            if(oper[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(!isOper(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else {
                int right = stack.pop();
                int left = stack.pop();
                switch (tokens[i]) {
                    case "+" : stack.push(left + right);break;
                    case "-" : stack.push(left - right);break;
                    case "*" : stack.push(left * right);break;
                    case "/" : stack.push(left / right);break;
                }
            }
        }
        return stack.peek();
    }


    @Test
    public void test() {
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
