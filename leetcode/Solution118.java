package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
        for(int i = 1; i <= numRows; ++i) {
            if(i == 1) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                res.add(tmp);
            }
            else if(i == 2) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                tmp.add(1);
                res.add(tmp);
            }
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                for(int j = 0; j < i - 2; ++j) {
                    tmp.add(res.get(i-2).get(j)+res.get(i-2).get(j+1));
                }
                tmp.add(1);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for(List<Integer> integers : new Solution118().generate(30))
            System.out.println(integers);
    }
}
