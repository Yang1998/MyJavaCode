package offer;

import java.util.Stack;

public class PrintListInReversedOrder_06 {
    public static void printListReversinglyIteratively(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur);
            stack.push(node);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val);
        }
    }
    public static void printListReversinglyRecursively(ListNode head) {
        if(head != null) {
            printListReversinglyRecursively(head.next);
            System.out.print(head.val);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printListReversinglyRecursively(head);
        System.out.println();
        printListReversinglyIteratively(head);
    }
}
