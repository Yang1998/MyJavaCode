package leetcode;

import java.util.*;
//超时
//public class Solution60 {
//    List<String> ss = new ArrayList<>();
//    public void generate(int index, int n, boolean[] visited, StringBuilder sb) {
//        if(index == n) {
//            ss.add(sb.toString());
//            return;
//        }
//
//        for(int i = 0; i < n; ++i) {
//            if(!visited[i]) {
//                sb.append(i + 1);
//                visited[i] = true;
//                generate(index + 1, n, visited, sb);
//                visited[i] = false;
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//    }
//    public String getPermutation(int n, int k) {
//        boolean[] vis = new boolean[n];
//        StringBuilder sb = new StringBuilder();
//        generate(0, n, vis, sb);
//        return ss.get(k - 1);
//    }
//    public static void main(String[] args) {
//        System.out.println(new Solution60().getPermutation(9, 136371));
//    }
//}

//通过5ms
public class Solution60 {
    public String ans = "";
    List<Integer> nums = new LinkedList<>();
    public int func(int x) {
        if(x == 0 || x == 1)
            return 1;
        else
            return func(x - 1) * x;
    }
    public void addElem(int i) {
        if(i < nums.size()) {
            ans += Integer.toString(nums.get(i));
            nums.remove(nums.get(i));
        }
    }
    public void gen(int n, int k){
        int temp = func(n - 1);
        int flag = (k - 1) / temp;
        addElem(flag);
        if(k % temp == 0) {
            while(!nums.isEmpty()) {
                addElem(nums.size() - 1);
            }
        }
        else if(k % temp == 1) {
            while (!nums.isEmpty()) {
                addElem(0);
            }
        }
        else {
            gen(n - 1, k % temp);
        }
    }
    public String getPermutation(int n, int k) {
        for(int i = 1; i <= n; ++i)
            nums.add(i);
        gen(n, k);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(4, 9));
    }
}

