package leetcode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = slow;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
