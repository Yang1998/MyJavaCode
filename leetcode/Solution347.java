package leetcode;

import java.util.*;

public class Solution347 {
    private static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first  = first;
            this.second = second;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n2.second - n1.second);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            }
            else {
                map.replace(nums[i], map.get(nums[i]), map.get(nums[i]) + 1);
            }
         }
        for(int key : map.keySet()) {
            priorityQueue.add(new Node(key, map.get(key)));
        }
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.poll().first);
        }
        return list;
    }
}
