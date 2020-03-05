package leetcode;

public class Solution526 {
    private int cnt = 0;

    private static boolean check(int target, int index) {
        return target % index == 0 || index % target == 0;
    }
    public int countArrangement(int N) {
        int[] array = new int[N];
        boolean[] vis = new boolean[N];
        dfs(array, vis, N, 0);
        return cnt;
    }

    private void dfs(int[] array, boolean[] visited, int N, int index) {
        if(index == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i] && check(i + 1, index + 1)) {
                array[index] = i + 1;
                visited[i] = true;
                dfs(array, visited, N, index + 1);
                visited[i] = false;
            }
        }
    }
}
