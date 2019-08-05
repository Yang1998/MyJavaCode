package Searching;

public class BinarySearch2 {
    //返回最后一个大于或等于target的索引，否则－１
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target) {
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        if(r >= 0 || nums[r] == target) return r;
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 1, 1, 4, 6, 9};
        System.out.println(search(nums, 1));
    }
}
