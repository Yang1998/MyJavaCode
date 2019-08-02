package leetcode;

/**
 * 如果nums[mid] < nums[mid+1],
 * 那么peak肯定在mid+1 ～ length - 1， 因为如果nums[mid+2] < nums[mid+1],return mid + 1
 * 如果nums[mid+2] > nums[mid+1], 那么继续往后，又因为nums[nums.length]等于负无穷，肯定会有peak
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int l = 0, r = nums.length - 1, mid;
        while(l < r) {
            mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Solution162 s = new Solution162();
        int[] TestCase = new int[]{1,2,1,3,5,6,4};
        System.out.println(s.findPeakElement(TestCase));
    }
}
