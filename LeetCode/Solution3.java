package leetcode;


public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hashTable = new boolean[128];
        int res = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if(!hashTable[s.charAt(j)]) {
                hashTable[s.charAt(j++)] = true;
                res = Math.max(res, j - i);
            }
            else{
                hashTable[s.charAt(i++)] = false;
            }
        }
        return res;
    }
}
