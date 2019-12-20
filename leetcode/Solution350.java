package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            if(value == null) {
                map.put(nums1[i], 1);
            }
            else {
                map.put(nums1[i], value + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer value = map.get(nums2[i]);
            if(value == null || value == 0) continue;
            map.put(nums2[i], value - 1);
            res.add(nums2[i]);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2};
        int[] nums2 = {1, 2, 2, 1};
        System.out.println(Arrays.toString(new Solution350().intersect(nums1, nums2)));
    }
}
