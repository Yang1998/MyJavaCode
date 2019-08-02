package leetcode;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        super();
    }
    ListNode(int x) {
        val = x;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        if(head == null) {
            sb.append("null");
        }
        else {
            for (int i = 0; head != null; i++, head = head.next) {
                if(i > 0)
                    sb.append("->");
                sb.append(head.val);
            }
        }
        return sb.toString();
    }


    public static ListNode createList(int[] array) {
        if(array == null)
            return null;

        int n = array.length;

        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for (int i = 0; i < n; i++) {
            ListNode newNode = new ListNode(array[i]);
            cur.next = newNode;
            cur = cur.next;
        }

        return dummyNode.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}

