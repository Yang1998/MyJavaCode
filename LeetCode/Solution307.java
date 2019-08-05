package leetcode;

public class Solution307 {
}

class NumArray {

    private int[] C;
    private int[] nums;
    private int lowvbit(int n) {
        return n & (-n);
    }

    public NumArray(int[] nums) {
        int size = nums.length;
        C = new int[size + 1];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < C.length; j += lowvbit(j)) {
                C[j] += nums[i];
            }
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        for (int j = i + 1; j < C.length; j += lowvbit(j)) {
            C[j] += (val - nums[i]);
        }
        nums[i] = val;
    }

    private int sumRange(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= lowvbit(i)) {
            sum += C[i];
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return sumRange(j) - sumRange(i - 1);
    }


    public static void main(String[] args) {
        int[] nums = {9, -8};
        NumArray bit = new NumArray(nums);
        bit.update(0, 3);
        System.out.println(bit.sumRange(1, 1));
        System.out.println(bit.sumRange(0, 1));
        bit.update(1, -3);
        System.out.println(bit.sumRange(0, 1));
    }
}
