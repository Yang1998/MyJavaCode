package leetcode;

public class Solution242 {
    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        int[] hashTable1 = new int[26];
        int[] hashTable2 = new int[26];
        final int OFFSET = 'a';
        for(int i = 0;i < s.length(); ++i) {
            hashTable1[s.charAt(i) - OFFSET] += 1;
        }
        for(int i = 0;i < t.length(); ++i) {
            hashTable2[t.charAt(i) - OFFSET] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(hashTable1[i] != hashTable2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("", ""));
    }
}
