package leetcode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode n1 = l1, n2 = l2;
        while (n1 != null && n2 != null) {
            if(n1.val > n2.val) {
                cur.next = n2;
                cur = cur.next;
                n2 = n2.next;
            }
            else{
                cur.next = n1;
                cur = cur.next;
                n1 = n1.next;
            }
        }

        if(n1 != null) {
            cur.next = n1;
        }
        if(n2 != null)
            cur.next = n2;

        return dummy.next;
    }
}
