package leetcode;

import java.util.*;
public class Solution1019 {

    public int[] nextLargerNodes(ListNode head) {
        if(head == null)
            return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int n = list.size();
        int[] res = new int[n];
        cur = head;
        for (int i = n - 2; i >= 0; i--) {
            if(list.get(i) < list.get(i + 1)) {
                res[i] = list.get(i + 1);
            }
            else if(list.get(i) < res[i + 1]) {
                res[i] = res[i + 1];
            }
            else {
                if(list.get(i) >= list.get(n - 1)) {
                    res[i] = 0;
                }
                else {
                    for (int j = i + 1; j < n; j++) {
                        if(list.get(i) < list.get(j)) {
                            res[i] = list.get(j);
                            break;
                        }
                    }

                }
            }
            if(list.get(n - 1) < list.get(i)) {
                list.set(n - 1, list.get(i));
            }
        }
        return res;
    }

}
