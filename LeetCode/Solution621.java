package leetcode;

import java.util.Arrays;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int num = tasks[i] - 'A';
            chars[num]++;
        }
        Arrays.sort(chars);
        int cnt = 0, index = 0;
        for (index = 25; index >= 0; index--) {
            if(chars[index] != chars[25]) break;
        }
        return (chars[25] - 1) * (n + 1) + 25 - index;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B' ,'B' ,'B'};
        System.out.println(new Solution621().leastInterval(tasks, 2));
    }
}
