package leetcode;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, res = 0, cur = 0;
        for (int i = 0; i < gas.length; ++i) {
            res += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if(cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        return res >= 0 ? start : -1;
    }
}
