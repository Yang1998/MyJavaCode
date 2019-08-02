package leetcode;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            }
            else if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        System.out.println(new Solution81().search(nums, 0));
    }
}
