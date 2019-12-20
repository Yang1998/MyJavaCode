package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) set2.add(i);
        if(set1.size() > set2.size()) {
            Set<Integer> tmp = set1;
            set1 = set2;
            set2 = tmp;
        }
        for(Integer i : set1) {
            if(set2.contains(i)) {
                res.add(i);
            }
        }
        int idx = 0;
        int[] ans = new int[res.size()];
        for(int i : res) {
            ans[idx++] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution349().intersection(nums1, nums2)));
    }
}
