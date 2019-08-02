package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {
    private TrieNode root;
    public TrieTree() {
        root = new TrieNode('\u0000', 0, new HashMap<Character, TrieNode>());
    }
    private class TrieNode {
        char ch;
        int freq;
        Map<Character, TrieNode> child;
        TrieNode(char c, int f, Map<Character, TrieNode> mp) {
            this.ch = c;
            this.freq = f;
            this.child = mp;
        }
    }
    public int query(String s) {
        TrieNode cur = root;
        if(cur == null || s == null || s.length() == 0)
            return 0;
        for(int i = 0; i < s.length(); ++i) {
            TrieNode tmp = cur.child.get(s.charAt(i));
            if(tmp == null) {
                return 0;
            }
            else
                cur = tmp;
        }
        return cur.freq;
    }
    public boolean find(String s) {
        TrieNode cur = root;
        if(cur == null || s == null || s.length() == 0)
            return false;
        for(int i = 0; i < s.length(); ++i) {
            TrieNode tmp = cur.child.get(s.charAt(i));
            if(tmp == null) {
                return false;
            }
            else {
                cur = tmp;
            }
        }
        return cur.freq != 0;
    }
    public void add(String s) {
        TrieNode cur = root;
        if(cur == null || s == null || s.length() == 0)
            return;
        for(int i = 0; i < s.length(); ++i) {
            TrieNode tmp = cur.child.get(s.charAt(i));
            if(tmp == null) {
                TrieNode newNode = new TrieNode(s.charAt(i), 0, new HashMap<Character, TrieNode>());
                cur.child.put(s.charAt(i), newNode);
                cur = cur.child.get(s.charAt(i));
            }
            else
                cur = tmp;
        }
        cur.freq++;
    }
    public boolean startWith(String prefix) {
        TrieNode cur = root;
        if(cur == null || prefix == null || prefix.length() == 0)
            return false;
        for(int i = 0; i < prefix.length(); ++i) {
            TrieNode tmp = cur.child.get(prefix.charAt(i));
            if(tmp == null) {
                return false;
            }
            else {
                cur = tmp;
            }
        }
        return true;
    }
    public void remove(String s) {
        TrieNode cur = root;
        TrieNode nodeToDel = root;
        if(s == null || cur == null || s.length() == 0)
            return;
        char ch = s.charAt(0);
        for(int i = 0; i < s.length(); ++i) {
            TrieNode tmp = cur.child.get(s.charAt(i));
            if(tmp == null)
                return;
            else {
                if(cur.child.size() > 1) {
                    nodeToDel = cur;
                    ch = s.charAt(i);
                }
                cur = tmp;
            }
        }
        cur.freq = 0;
        if(nodeToDel.child.get(ch).child.size() == 0)
            nodeToDel.child.remove(ch);
    }
    public static void main(String[] args) {
        TrieTree root = new TrieTree();
        root.add("this");
        root.add("");
        root.add("isa");
        root.add("Hello");
        root.add("world");
        root.add("he");
        root.add("isA");
        for(int i = 0; i < 5; ++i)
            root.add("isa");
        System.out.println(root.query(null));
        root.remove("isa");
        System.out.println(root.query("isA"));
        System.out.println(root.startWith("isA"));

    }
}