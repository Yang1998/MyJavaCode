package offer;

public class DuplicationInArrayNoEdit_03_02 {
    /**
     * @param nums 含重复数字的数字，数字大小在1-n,数组大小为n+1
     * @return -1 indicate not found
     */
    public static int getduplication(int[] nums) {
        if(nums == null || nums.length < 2)
            return -1;
        int n = nums.length;
        int l = 1, r = n - 1;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            int cnt = countRange(nums, l, mid);
            //如果l==r ,则此时范围内就只有一个数，如果在这个范围的数字超过了1，说明这个数字重复了。
            if(l == r) {
                if(cnt > 1) {
                    return l;
                }
                else {
                    break;
                }
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

    private static int countRange(int[] nums, int l, int r) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(l <= nums[i] && nums[i] <= r) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getduplication(nums));
    }
}
