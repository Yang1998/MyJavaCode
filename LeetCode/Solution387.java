package leetcode;

import java.util.TreeMap;

public class Solution387 {
    public int firstUniqChar(String s) {
        if(s == null) {
            return -1;
        }
        boolean[] isvisited = new boolean[s.length()];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            char c = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                if(s.charAt(j) == c && !isvisited[j]) {
                    isvisited[j] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag && !isvisited[i])
                return i;
            else
                flag = false;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution387().firstUniqChar("leetcode"));
//        System.out.println(new Solution387().firstUniqChar("loveleetcode"));
        System.out.println(new Solution387().firstUniqChar("loveleetcode"));
        System.out.println(new Solution387().firstUniqChar("cc"));
    }
}
