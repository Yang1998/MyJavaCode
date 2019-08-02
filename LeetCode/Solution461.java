package leetcode;

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for(int i = 0;i < 32; ++i) {
            if(((x & 1) ^ (y & 1)) == 1)
                cnt++;
            x >>>= 1;
            y >>>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution461().hammingDistance(1, 4));
    }
}
