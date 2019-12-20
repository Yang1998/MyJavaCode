package leetcode;

import java.util.Arrays;

public class Solution338 {
//res[i >> 1] 在前面计算过，i&1 为是否要加上>>1 后的最后一位数，tql...
//public int[] countBits(int num) {
//    int[] res = new int[num + 1];
//    for(int i = 0;i<= num;i++){
//        res[i] = res[i >> 1] + (i & 1);  //注意i&1需要加括号
//    }
//    return res;
//}
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for(int i = 0; i <= num; ++i) {
            int count = 0;
            int x = i;
            while (x != 0) {
                count++;
                x = x & (x - 1);
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution338().countBits(5)));
    }
}
