package linkedList;

public class valueOfMid {
    public static Node getMid(Node head) {
        if(head == null || head.next == null)
            return head;

        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
