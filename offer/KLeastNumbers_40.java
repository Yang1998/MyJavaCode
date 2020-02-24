package offer;

import java.util.PriorityQueue;

public class KLeastNumbers_40 {
    int[] getLeastNumbers(final int[] nums, int k) {
        if(nums == null || nums.length == 0 || k >= nums.length) {
            throw new IllegalArgumentException("参数异常!");
        }
        int[] res = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            } else {
                priorityQueue.add(num);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
