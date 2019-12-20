package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();

        for(int i = left;i <= right; ++i) {
            if(check(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean check(int num) {
        if(num < 1)
            return false;
        int tmp = num;
        while (tmp > 0) {
            if(tmp % 10 == 0)
                return false;
            else if(num % (tmp % 10) != 0)
                return false;
            tmp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution728().selfDividingNumbers(1, 22));
    }
}
