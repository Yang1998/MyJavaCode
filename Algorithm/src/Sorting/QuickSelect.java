package Sorting;

public class QuickSelect {

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    public static int quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] nums, int l, int r, int k) {
        int index = partition(nums, l, r);
        if(index - l == k) {
            return nums[index];
        }
        else if(index - l < k) {
            return quickSelect(nums, index + 1, r, k - (index - l + 1));
        }
        else {
            return quickSelect(nums, l, index - 1, k);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {5, 8, 10, 9, 7};
//        int[] nums = {2, 1};
        int[] nums = {5,2,4,1,3,6,0};
        System.out.println(quickSelect(nums, 4));
    }
}
