package linkedList;

public class hasCycle {
    public static boolean isCyclic(Node head) {
        if(head == null) {
            return false;
        }

        Node fast = head.next;
        Node slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            if(fast == slow) {
                flag = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return flag;
    }
}
