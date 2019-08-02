package linkedList;

public class reverseList {
    public static Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node tmp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
