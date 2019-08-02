package leetcode;

public class Solution204 {
    public int countPrimes(int n) {
        if(n < 2)
            return 0;
        int res = 0;
        boolean[] hashTable = new boolean[n];
        for(int i = 2; i < n; ++i) {
            if(!hashTable[i]) {
                for(int j = 2 * i; j < n; j += i) {
                    hashTable[j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if(!hashTable[i])
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(10));
    }
}
