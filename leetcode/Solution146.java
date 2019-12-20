package leetcode;

import java.util.HashMap;

/**
 * 双链表加哈希表实现LRU算法
 */
class LRUCache {
    static class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> hashMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = head;
        hashMap = new HashMap<>((int)(capacity / 0.75) + 1);
    }

    private void removeNode(Node cur) {
        if(cur == tail) {
            tail = cur.pre;
            tail.next = null;
            cur.pre = null;
        }
        else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.pre = null;
            cur.next = null;
        }
    }

    private void add(Node cur) {
        tail.next = cur;
        cur.pre = tail;
        tail = cur;
    }
    public int get(int key) {
        Node cur = hashMap.get(key);
        if(cur == null)
            return -1;
        else {
            removeNode(cur);
            add(cur);
            return cur.value;
        }
    }

    public void put(int key, int value) {
        Node cur = hashMap.get(key);
        if(cur == null) {
            Node node = new Node(key, value);
            hashMap.put(key, node);
            add(node);

            if (hashMap.size() > capacity && head != tail) {
                Node outdated = head.next;
                removeNode(outdated);
                hashMap.remove(outdated.key);
            }
        }
        else {
            removeNode(cur);
            add(cur);
            cur.value = value;
        }

    }
}

public class Solution146 {

}
