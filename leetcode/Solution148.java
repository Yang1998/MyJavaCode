package leetcode;

import java.util.Arrays;
import java.util.List;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        return head == null ?
                null :
                mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //将链表从中间断开
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            }
            else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }

        if(l != null)
            cur.next = l;
        if(r != null)
            cur.next = r;

        return dummyNode.next;
    }


    public static void main(String[] args) {
        int[] ints = {4, 2, 1, 3, 6, 9, 0};
        ListNode head = ListNode.createList(ints);
        System.out.println(ListNode.toString(head));
        head = new Solution148().sortList(head);
        System.out.println(ListNode.toString(head));
    }
}
