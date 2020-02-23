package offer;

public class CopyComplexList_35 {
    private static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        public ComplexListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 复制节点
     * @param node
     */
    private void cloneNodes(ComplexListNode node) {
        ComplexListNode cur = node;
        while (cur != null) {
            ComplexListNode cloned = new ComplexListNode(cur.value);
            cloned.next = cur.next;
            cur.next = cloned;
            cur = cloned.next;
        }
    }

    /**
     * 连接未赋值的sibling节点
     * @param node
     */
    private void connectSiblingNodes(ComplexListNode node) {
        ComplexListNode cur = node;
        while (cur != null) {
            ComplexListNode cloned = cur.next;
            if(cur.sibling != null) {
                cloned.sibling = cur.sibling.next;
            }
            cur = cloned.next;
        }
    }

    /**
     * 将链表展开，一分为二
     * @param node
     * @return 克隆后的链表
     */
    private ComplexListNode reconnectNodes(ComplexListNode node) {
        ComplexListNode cur = node;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedCur = null;
        if(node != null) {
            clonedHead = node.next;
            clonedCur = clonedHead;
            cur.next = clonedCur.next;
            cur = cur.next;
        }
        while (cur != null) {
            clonedCur.next = cur.next;
            clonedCur = clonedCur.next;
            cur.next = clonedCur.next;
            cur = cur.next;
        }
        return clonedHead;
    }

    /**
     * 主方法
     * @param node
     * @return
     */
    public ComplexListNode clone(ComplexListNode node) {
        cloneNodes(node);
        connectSiblingNodes(node);
        return reconnectNodes(node);
    }
}
