package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution394 {
    public String decodeString(String s) {
        if(s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        Deque<Integer> stackNum = new LinkedList<>();
        Deque<String> stackStr = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        while (idx < s.length()) {
            if(Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx++) - '0';
                }
                stackNum.push(num);
            }
            else if(s.charAt(idx) == '[') {
                stackStr.push(s.charAt(idx++) + "");
            }
            else if(Character.isLetter(s.charAt(idx))) {
                StringBuilder str = new StringBuilder();
                while (idx < s.length() && Character.isLetter(s.charAt(idx))) {
                    str.append(s.charAt(idx++));
                }
                if(!stackStr.isEmpty())
                    stackStr.push(str.toString());
                else
                    list.add(str.toString());
            }
            else if(s.charAt(idx) == ']') {
                StringBuilder str = new StringBuilder();
                int popN = stackNum.pop();
                while (!stackStr.peek().equals("[")) {
                    str.append(new StringBuilder(stackStr.pop()).reverse());
                }
                stackStr.pop();//delete '['
                str.reverse();
                String tmp = str.toString();
                for (int i = 0; i < popN - 1; i++) {
                    str.append(tmp);
                }
                if(!stackStr.isEmpty()) {
                    stackStr.push(str.toString());
                }
                else {
                    list.add(str.toString());
                }
                idx++;
            }
        }
        for(String ss : list) {
            sb.append(ss);
        }
        while (!stackStr.isEmpty()) {
            sb.append(stackStr.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        System.out.println(new Solution394().decodeString("3[a]2[bc]"));
//        System.out.println(new Solution394().decodeString("3[a2[c]]"));
//        System.out.println(new Solution394().decodeString("2[abc]3[cd]ef"));
//        System.out.println(new Solution394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
//        System.out.println("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
        System.out.println(new Solution394().decodeString("sd2[f2[e]g]i"));
    }
}
