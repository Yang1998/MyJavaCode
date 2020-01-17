package leetcode;

import java.util.Arrays;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        if(!version1.contains(".")) {
            v1 = new String[]{version1};
        }
        if(!version2.contains(".")) {
            v2 = new String[]{version2};
        }
        if(v1.length < v2.length) {
            int originalSize = v1.length;
            v1 = Arrays.copyOf(v1, v2.length);
            for (int i = originalSize; i < v2.length; i++) {
                v1[i] = "0";
            }
        } else if(v1.length > v2.length) {
            int originalSize = v2.length;
            v2 = Arrays.copyOf(v2, v1.length);
            for (int i = originalSize; i < v1.length; i++) {
                v2[i] = "0";
            }
        }
        int index = 0;
        while (index < v1.length && index < v2.length) {
            int n1 = Integer.parseInt(v1[index]);
            int n2 = Integer.parseInt(v2[index]);
            if(n1 > n2) {
                return 1;
            } else if(n1 < n2) {
                return -1;
            } else {
                index++;
            }
        }
        return 0;
    }


//    public static void main(String[] args) {
//        System.out.println(compareVersion("0.1", "1.1")); // -1
//        System.out.println(compareVersion("1.1.1", "1")); // 1
//        System.out.println(compareVersion("7.5.2.4", "7.5.3")); // -1
//        System.out.println(compareVersion("1.01", "1.001")); // 0
//        System.out.println(compareVersion("1.0", "1.0.0")); // 0
//    }
}
