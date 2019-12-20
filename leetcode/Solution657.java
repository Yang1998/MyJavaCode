package leetcode;

public class Solution657 {
    public boolean judgeCircle(String moves) {
        if(moves == null)
            return true;
        int horizontal = 0, vertical = 0;
        for(int i = 0; i < moves.length(); ++i) {
            switch (moves.charAt(i)) {
                case 'L' : horizontal--;break;
                case 'R' : horizontal++;break;
                case 'U' : vertical++;break;
                case 'D' : vertical--;break;
            }
        }
        return horizontal == 0 && vertical == 0;
    }

    public static void main(String[] args) {
        String words = "UD";
        System.out.println(new Solution657().judgeCircle(words));
    }
}
