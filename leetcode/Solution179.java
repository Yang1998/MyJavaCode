package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = Integer.toString(nums[i]);
    }
        Arrays.sort(strings, (o1, o2) -> {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
        });
        if("0".equals(strings[0])) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        int[] nums = {3,30,34,5,9};
//        int[] nums = {10,2};
        System.out.println(largestNumber(nums));
    }
}
