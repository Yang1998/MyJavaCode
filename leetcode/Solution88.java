package leetcode;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        if(j >= 0) {
            for (int k = 0; k <= index; k++) {
                nums1[k] = nums2[k];
            }
        }
    }
}
