package offer;

public class ListNode {
    int      val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    ListNode(ListNode node) {
        this.val = node.val;
        this.next = node.next;
    }
}
