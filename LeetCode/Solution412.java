package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; ++i) {
            if(i % 3 == 0 && i % 5 == 0)
                res.add("FizzBuzz");
            else if(i % 3 == 0) {
                res.add("Fizz");
            }
            else if(i % 5 == 0)
                res.add("Buzz");
            else
                res.add("" + i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution412().fizzBuzz(15));
    }
}
