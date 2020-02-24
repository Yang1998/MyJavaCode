package offer;


public class StringPermutation_38 {
    public void permutation(String str) {
        if (str == null) {
            return;
        }
        boolean[] vis = new boolean[str.length()];
        char[] res = new char[str.length()];
        permutation(str, res, 0, vis);
    }

    private void permutation(String str, char[] res, int index, boolean[] visited) {
        if (index == str.length()) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                res[index] = str.charAt(i);
                visited[i] = true;
                permutation(str, res, index + 1, visited);
                visited[i] = false;
            }
        }
    }
}
