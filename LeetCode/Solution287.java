package leetcode;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length, mid;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            int cnt = countRange(nums, l, mid);
            if(l == r) {
                if(cnt > 1) {
                    return l;
                }
                else
                    break;
            }
            if(cnt > (mid - l + 1)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] nums, int l, int r) {
        int cnt = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(l <= nums[i] && nums[i] <= r) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new Solution287().findDuplicate(nums));
    }
}
