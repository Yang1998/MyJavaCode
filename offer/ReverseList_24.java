package offer;

public class ReverseList_24 {
    public ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        ListNode cur = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
    }
}
