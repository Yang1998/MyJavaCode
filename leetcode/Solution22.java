package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution22 {
    public void helper(List<String> list, int n, int l, int r, String s) {
        if (l > n || r > n)
            return;
        if (l == n && r == n)
            list.add(s);
        if (l >= r) {
            String tmp = new String(s);
            helper(list, n, l + 1, r, s + "(");
            helper(list, n, l, r + 1, tmp + ")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res, n, 0 , 0, "");
        return res;
    }
    public static void main(String[] args) {

        System.out.println(new Solution22().generateParenthesis(3).toString());
    }
}
