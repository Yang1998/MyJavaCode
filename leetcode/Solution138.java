package leetcode;

public class Solution138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        copyListWithNoRandomNode(head);
        linkRandomNode(head);
        return doCopyList(head);
    }

    private Node doCopyList(Node head) {
        Node node = head;
        Node cur = null;
        Node newHead = null;
        if(node != null) {
            newHead = cur = node.next;
            node.next = cur.next;
            node = node.next;
        }

        while (node != null) {
            cur.next = node.next;
            cur = cur.next;
            node.next = cur.next;
            node = node.next;
        }
        return newHead;
    }

    private void linkRandomNode(Node head) {
        if(head == null) {
            return;
        }
        Node node = head.next;
        if(head.random != null) {
            node.random = head.random.next;
        }
        linkRandomNode(node.next);
    }

    private void copyListWithNoRandomNode(Node head) {
        if(head == null) {
            return;
        }
        Node node = new Node(head.val);
        node.next = head.next;
        head.next = node;
        copyListWithNoRandomNode(node.next);
    }
}
