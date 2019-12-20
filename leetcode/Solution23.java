package leetcode;

import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for(ListNode node : lists) {
            while(node != null) {
                priorityQueue.add(node.val);
                node = node.next;
            }
        }

        while (!priorityQueue.isEmpty()) {
            cur.next = new ListNode(priorityQueue.poll());
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
