package offer;

public class DuplicationInArray_03_01 {
    public static boolean duplicate(int[] nums, int val) {
        if(nums == null || nums.length < 2)
            return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0 || nums[i] > n - 1) {
                return false;
            }
        }

        for(int i = 0; i < n; ++i) {
            while (nums[i] != i) {
                if(nums[i] == i) {
                    val = nums[i];
                    return true;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return false;
    }
}
