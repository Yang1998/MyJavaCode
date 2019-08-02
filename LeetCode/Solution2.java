package leetcode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        ListNode p = l1, q = l2;
        int carry = 0;
        while(p != null || q != null) {
            int x = p == null ? p.val : 0;
            int y = q == null ? q.val : 0;
            int val = x + y + carry;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            carry = val / 10;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
