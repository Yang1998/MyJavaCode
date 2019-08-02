package leetcode;

import java.util.Arrays;

public class Solution806 {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        if(S == null || S.length() == 0) {
            return res;
        }
        int cnt = 0;
        int row = 1;
        for (int i = 0; i < S.length(); i++) {
            cnt += widths[S.charAt(i) - 'a'];
            if(cnt > 100) {
                cnt = widths[S.charAt(i) - 'a'];
                ++row;
            }
        }
        res[0] = row;
        res[1] = cnt;
        return res;
    }

    public static void main(String[] args) {
        Solution806 solution806 = new Solution806();
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(solution806.numberOfLines(widths, s)));
    }
}
