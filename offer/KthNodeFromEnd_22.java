package offer;

public class kthNodeFromEnd_22 {
    // note: 输入的k 可能为<= 0 的数, k 还可能大于链表长度
    public static ListNode findKthToTail(ListNode node, int k) {
        if(node == null || k <= 0) {
            return null;
        }
        ListNode pre = node;
        ListNode cur = null;
        for (int i = 0; i < k - 1; i++) {
            if(pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        cur = node;
        while (pre.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}
