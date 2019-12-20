package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new LinkedList<>();
        int lowN = getN(low);
        int highN = getN(high);
        for (int i = lowN; i <= highN; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                int tmp = getNext(j, i);
                if(tmp > high) {
                    return res;
                }
                if(checkIfInRange(tmp, low, high)) {
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    private static boolean checkIfInRange(int num, int low, int high) {
        return low <= num && num <= high;
    }

    // 确定num 的位数
    private static int getN(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num /= 10;
        }
        return res;
    }

    // 比如想得到12345, 那就调用getNext(1, 5)
    private static int getNext(int head, int N) {
        int res = head;
        for (int i = 1; i < N; i++) {
            res = res * 10 + ++head;
        }
        return res;
    }
}
