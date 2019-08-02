package Searching;
//找到第一个等于target的下标，否则－１
public class BinarySearch1 {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if(l == 0 || nums[l] == target) return l;
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 2, 3, 4, 5};
        System.out.println(search(nums, 1));
    }
}
