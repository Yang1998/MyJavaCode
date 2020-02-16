package util;

public class StringUtil {
    private StringUtil() {}

    public static int[] parseString2IntArray(String str) {
        String[] s = str.split(" ");
        int[] res = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            res[i] = Integer.parseInt(s[i]);
        }
        return res;
    }
}
