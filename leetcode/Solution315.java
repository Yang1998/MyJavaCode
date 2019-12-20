package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution315 {
    static class Node{
        int val;
        int index;
        public Node(){}
        public Node(int val, int index) {
            this.val   = val;
            this.index = index;
        }
    }
    int[] C;
    private int lowbit(int n) {
        return n & (-n);
    }
    
    
    private int getSum(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= lowbit(i)) {
            sum += C[i];
        }
        return sum;
    }
    
    private void update(int index, int val) {
        for (int i = index; i < C.length; i += lowbit(i)) {
            C[i] += val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Node[] nodes = new Node[n];
        C = new int[n + 1];
        int[] newNums = new int[n];
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        //升序排序
        Arrays.sort(nodes, (o1, o2) -> (o1.val - o2.val));
        //离散化
        for (int i = 0; i < n; i++) {
            if(i == 0 || nodes[i].index != nodes[i-1].index) {
                newNums[nodes[i].index] = 1 + i;
            }
            else {
                newNums[nodes[i].index] = newNums[nodes[i].index];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            update(newNums[i], 1);
            res.addFirst(getSum(newNums[i] - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution315().countSmaller(new int[]{5, 2, 6, 1}));
    }
}
