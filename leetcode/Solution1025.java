package leetcode;


/**
 * 1.动态规划
 * 2.如果N为奇数，那么爱丽丝执行一次后，N为偶数，鲍勃就每次执行一次-1，最后N到2，爱丽丝必输
 * 3.如果N为偶数，爱丽丝执行一次-1，最后鲍勃必输
 */
public class Solution1025 {
    public boolean divisorGame(int N) {
        return (N & 1) != 1;
    }

    public static void main(String[] args) {
        Solution1025 s = new Solution1025();
        System.out.println(s.divisorGame(3));
    }
}
