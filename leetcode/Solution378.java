package leetcode;

import java.util.PriorityQueue;

public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int size = priorityQueue.size();
                if(size == k) {
                    if(matrix[i][j] < priorityQueue.peek()) {
                        priorityQueue.poll();
                        priorityQueue.add(matrix[i][j]);
                    }
                } else {
                        priorityQueue.add(matrix[i][j]);
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(new Solution378().kthSmallest(matrix, k));
    }
}
