package leetcode;

public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        if(num_people == 1) {
            return new int[]{candies};
        }
        int[] res = new int[num_people];
        int index = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if(candies == 0) {
                    return res;
                }
                if(index <= candies) {
                    candies -= index;
                    res[i] += index++;
                } else {
                    res[i] += candies;
                    return res;
                }
            }
        }
        return res;
    }
}
