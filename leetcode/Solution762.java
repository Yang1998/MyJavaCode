package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution762 {

    private static boolean[] hashTable = new boolean[] {
            false, false, true, true, false, true, false, true, false, false,
            false, true, false, true, false, false, false, true, false, true,
            false, false, false, true, false, false, false, false, false, true,
            false, true, false
    };


    public int countPrimeSetBits(int L, int R) {
        int cnt = 0;
        for(int i = L; i <= R; ++i) {
            if(helper(i))
                cnt++;
        }
        return cnt;
    }

    private boolean helper(int n) {
        int cnt = 0;
        while(n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return hashTable[cnt];
    }


    public static void main(String[] args) {
        System.out.println(new Solution762().countPrimeSetBits(10, 15));
    }
}
