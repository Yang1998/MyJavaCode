package leetcode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        ListNode cur = head, pre = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        ListNode post = head;
        while (cur != null) {
            pre = post;
            post = post.next;
            cur = cur.next;
        }
        pre.next = post.next;
        post.next = null;
        return dummyNode.next;
    }
}
