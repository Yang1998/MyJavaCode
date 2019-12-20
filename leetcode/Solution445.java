package leetcode;

import java.util.Stack;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode h1 = l1, h2 = l2, cur = dummy;
        while (h1 != null) {
            stack1.push(h1);
            h1 = h1.next;
        }
        while (h2 != null) {
            stack2.push(h2);
            h2 = h2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int x = stack1.pop().val + stack2.pop().val + carry;
            ListNode newNode = new ListNode(x % 10);
            carry = x / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        while (!stack1.isEmpty()) {
            int x = stack1.pop().val + carry;
            ListNode newNode = new ListNode(x % 10);
            carry = x / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        while (!stack2.isEmpty()) {
            int x = stack2.pop().val + carry;
            ListNode newNode = new ListNode(x % 10);
            carry = x / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        if(carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
}
