package Searching;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target) {
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 9, 11, 19, 100};
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearch(nums, 3));
        System.out.println(binarySearch(nums, 6));
        System.out.println(binarySearch(nums, 9));
        System.out.println(binarySearch(nums, 11));
        System.out.println(binarySearch(nums, 19));
        System.out.println(binarySearch(nums, 20));
    }

}
