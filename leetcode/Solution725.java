package leetcode;

import java.util.LinkedList;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        int cnt = 0;
        ListNode listNode = root, cur = root;
        while(listNode != null) {
            cnt++;
            listNode = listNode.next;
        }
        int size = cnt / k;
        int reminder = cnt % k;
        for(int i = 0, j = 0; i < k; ++i) {
            ListNode head = cur;
            ListNode pre = cur;
            for(int x = 0; x < size; ++x) {
                pre = cur;
                if(cur != null)
                    cur = cur.next;
                else
                    break;
            }
            if(reminder > 0) {
                pre = cur;
                cur = cur.next;
                reminder--;
            }
            if(pre != null)
                pre.next = null;
            ans[i] = head;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode[] res = new Solution725().splitListToParts(head, 3);
        for(ListNode node : res) {
            System.out.println(ListNode.toString(node));
        }
    }
}
