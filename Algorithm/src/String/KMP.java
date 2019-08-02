package Algorithm;

public class KMP {
    private static int[] getNext(String p) {
        int n = p.length();
        int[] next = new int[n];
        next[0] = -1;
        int k = -1;
        int j = 0;
        //k为前缀索引，j为后缀索引
        while (j < n - 1) {
            if(k == -1 || p.charAt(k) == p.charAt(j)) {
                ++k;
                ++j;
                next[j] = k;
            }
            else {
                k = next[k];
            }
        }
        return next;
    }

    public static int kmp(String s, String p, int[] next) {
        int m = s.length();
        int n = p.length();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }
        if(j == n) {
            return i - j;
        }
        return -1; //indicate not found
    }
    public static void main(String[] args) {
        String s = "abacababc";
        String p = "abab";
        System.out.println(kmp(s, p, getNext(p)));
    }
}
