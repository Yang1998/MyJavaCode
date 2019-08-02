package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] strings = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); ++j) {
                sb.append(strings[words[i].charAt(j) - 97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        System.out.println(new Solution804().uniqueMorseRepresentations(words));
    }
}
