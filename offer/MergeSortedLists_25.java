package offer;

public class MergeSortedLists_25 {
    ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null) {
            return node2;
        } else if(node2 == null) {
            return node1;
        }
        ListNode head = null;
        if(node1.val > node2.val) {
            head = node2;
            head.next = merge(node1, node2.next);
        } else {
            head = node1;
            head.next = merge(node1.next, node2);
        }
        return head;
    }
}
