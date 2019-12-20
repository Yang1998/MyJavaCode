package leetcode;

public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode cur = head;
        while(cur != null) {
            res = res * 2 + cur.val;
            cur = cur.next;
        }
        return res;
    }
}
