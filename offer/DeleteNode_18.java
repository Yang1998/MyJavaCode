package offer;

public class DeleteNode_18 {
    /**
     *
     * @param pListHead 给定链表的头结点
     * @param toBeDeleted 待删除的节点
     * @return 返回删除给定节点后链表的头结点
     */
    public ListNode deleteNode(ListNode pListHead, ListNode toBeDeleted) {
        if(pListHead == null || toBeDeleted == null) {
            return null;
        }
        // 如果待删除的节点和头结点一致，直接返回null
        if(pListHead == toBeDeleted) {
            return null;
        }
        // 如果被删除的节点不为尾节点
        else if(toBeDeleted.next != null) {
            ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
            next.next = null; // 被gc回收
        }
        // 被删除的节点是尾节点且整个链表不止一个节点
        else {
            ListNode cur = pListHead;
            while (cur.next != toBeDeleted) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return pListHead;
    }
}

