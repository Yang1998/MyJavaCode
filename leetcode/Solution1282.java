package leetcode;

import java.util.*;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> target = map.get(groupSizes[i]);
            if (null == target) {
                target = new LinkedList<>();
                target.add(i);
                map.put(groupSizes[i], target);
            } else {
                target.add(i);
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            // 如果list的大小超过了key值，则新建一个list存
            if (entry.getValue().size() > entry.getKey()) {
                // 分开存
                List<Integer> value = entry.getValue();
                List<Integer> tmp = new LinkedList<>();
                for (Integer integer : value) {
                    // 如果超过了大小， 则copy一份, 清空
                    if (tmp.size() == entry.getKey()) {
                        List<Integer> target = new LinkedList<>(tmp);
                        tmp.clear();
                        res.add(target);
                    }
                    tmp.add(integer);
                }
                if(tmp.size() > 0) {
                    res.add(tmp);
                }
            } else {
                res.add(entry.getValue());
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        System.out.println(new Solution1282().groupThePeople(groupSizes));
    }
}
