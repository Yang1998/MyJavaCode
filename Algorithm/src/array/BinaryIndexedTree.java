package array;
/**
 * 树状数组实现
 * Ｃ[i] 中的下标从１开始
 */

public class BinaryIndexedTree {
    int size;
    int[] C;
    private static int lowbit(int x) {
        return x & (-x);
    }
    private void checkRange(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index=" + index);
    }
    public BinaryIndexedTree(int[] nums) {
        C = new int[nums.length + 1];
        size = C.length;
        for (int i = 0; i < nums.length; i++) {
            update(i + 1, nums[i]);
        }
    }

    /**
     * 返回给定数组[0,n]的和
     * @param n　
     * @return sum
     */
    public int getSum(int n) {
        checkRange(n);
        int sum = 0;
        for(int i = n + 1; i > 0; i -= lowbit(i)) {
            sum += C[i];
        }
        return sum;
    }

    /**
     * 返回给定数组[x,y] 的和
     * @param x　左边界
     * @param y　右边界
     */
    public int getSum(int x, int y) {
        checkRange(x);
        checkRange(y);
        return getSum(y) - getSum(x - 1);
    }

    /**
     * 更新数组index处的值，加上n
     * @param index 数组的索引
     * @param n　加上的值
     */
    public void update(int index, int n) {
        checkRange(index);
        for (int i = index = 1; i < C.length; i += lowbit(i)) {
            C[i] += n;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BinaryIndexedTree bit = new BinaryIndexedTree(nums);
        System.out.println(bit.getSum(4));

    }
}
