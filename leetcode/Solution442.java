package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null)
            return res;
        for(int i = 0; i < nums.length; ++i) {
            int m = Math.abs(nums[i]);
            if(nums[m - 1] < 0) {
                res.add(m);
            }
            else {
                nums[m - 1] *= -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tests = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(new Solution442().findDuplicates(tests));
    }
}
