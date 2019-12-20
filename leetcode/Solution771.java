package leetcode;

public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        boolean[] hash = new boolean[60];
        for(int i = 0; i < J.length(); ++i) {
            hash[J.charAt(i) - 65] = true;
        }
        for(int i = 0; i < S.length(); ++i) {
            if(hash[S.charAt(i) - 65]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(new Solution771().numJewelsInStones(J, S));
    }
}
