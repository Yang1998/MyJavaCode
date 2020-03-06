package offer;

import java.util.ArrayList;
import java.util.List;

public class ContinuousSequenceWithSum_02_57 {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1;
        int sum = 0;
        int mid= target / 2;
        List<int[]> res = new ArrayList<>();
        while (i <= mid) {
            if(sum == target) {
                res.add(toArray(i, j));
                sum -= i++;
            } else if(sum > target) {
                sum -= i++;
            } else {
                sum += j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private static int[] toArray(int begin, int end) {
        int[] ans = new int[end - begin];
        for (int i = begin; i < end; i++) {
            ans[i - begin] = i;
        }
        return ans;
    }
}
