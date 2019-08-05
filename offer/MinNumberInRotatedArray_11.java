package offer;

public class MinNumberInRotatedArray_11 {

    public static int min(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        int midIndex = left;
        while (nums[left] >= nums[right]) {
            if(right - left == 1) {
                midIndex = right;
                break;
            }
            midIndex = left + (right - left) / 2;
            if(nums[left] == nums[midIndex] && nums[midIndex] == nums[right]) {
                return MInOrder(nums, left, right);
            }

            if(nums[midIndex] >= nums[left]) {
                left = midIndex;
            }
            else if(nums[midIndex] <= nums[right]) {
                right = midIndex;
            }
        }
        return nums[midIndex];
    }


    private static int MInOrder(int[] nums, int l, int r) {
        int min = nums[l];
        for (int i = l; i <= r; i++) {
            min = Math.min(nums[i], min);
        }
        return min;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        System.out.println(min(nums));
    }
}
