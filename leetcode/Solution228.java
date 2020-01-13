package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        int first = nums[0], last = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if(cur == last + 1) {
                last = cur;
            } else {
                if(last == first) {
                    res.add(first + "");
                } else {
                    res.add(first + "->" + last);
                }
                first = last = cur;
            }
        }
        if(last == first) {
            res.add(first + "");
        } else {
            res.add(first + "->" + last);
        }
        return res;
    }
}
