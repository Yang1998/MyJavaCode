package leetcode;

import java.util.*;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                else {
                    return o1[1] - o2[1];
                }
            }
        });
        for(int i = 0; i < intervals.length - 1; ++i) {
            int[] cur = intervals[i];
            int[] post = intervals[i+1];
            if(cur[1] >= post[0]) {
                int[] newArr;
                if(cur[1] < post[1]) {
                    newArr = new int[]{cur[0], post[1]};
                }
                else {
                    newArr = cur;
                }
                intervals[i+1] = newArr;
            }
            else {
                res.add(cur);
            }
        }
        res.add(intervals[intervals.length - 1]);
        int[][] ans = new int[res.size()][];
        ans = res.toArray(ans);
        return ans;
    }


    public static void main(String[] args) {
        int[][] ints = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] res = new Solution56().merge(ints);
        for(int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }
}
