package offer;

public class EntryNodeInListLoop_23 {
    /**
     * 判断是否有环，有则返回环中间的一个节点,没有则返回null
     * @param node
     * @return
     */
    private ListNode meetingNode(ListNode node) {
        if(node == null) {
            return null;
        }

        ListNode slow = node.next;
        if(slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if(slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 返回链表中环的入口节点，没有环则返回null
     * @param node 链表的头结点
     * @return 入口节点 or nullptr
     */
    public ListNode entryNodeOfLoop(ListNode node) {
        ListNode meetingNode = meetingNode(node);
        if(meetingNode == null) {
            return null;
        }

        int nodesInLoop = 1;
        ListNode cur = meetingNode;
        while (cur.next != meetingNode) {
            cur = cur.next;
            nodesInLoop++;
        }
        cur = node;
        for (int i = 0; i < nodesInLoop; i++) {
            cur = cur.next;
        }
        ListNode curr = node;
        while (cur != curr) {
            cur = cur.next;
            curr = curr.next;
        }
        return cur;
    }
}
