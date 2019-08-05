package offer;

import java.util.Arrays;

public class ReplaceSpaces_05 {
    public static char[] replaceBlacks(char[] string, int len) {
        if(string == null || string.length == 0) {
            return string;
        }
        int cnt = 0;
        for(int i = 0; i < len; ++i) {
            char c = string[i];
            if(c == ' ') {
                cnt++;
            }
        }
        if(string.length < len + cnt * 2) {
            string = Arrays.copyOf(string, len + cnt * 2);
        }
        int n = len + cnt * 2;
        int tail = n - 1, head = len - 1;
        while (cnt > 0) {
            if(string[head] != ' ') {
                string[tail--] = string[head--];
            }
            else {
                string[tail--] = '0';
                string[tail--] = '2';
                string[tail--] = '%';
                head--;
                cnt--;
            }
        }
        return string;
    }

    static void test1() {
        String s = "We are Happy!";
        char[] string = s.toCharArray();
        string = replaceBlacks(string, s.length());
        for(char c : string)
            System.out.print(c);
        System.out.println();
    }
    static void test2() {
        char[] string = replaceBlacks(null, 0);
        if(string == null) {
            System.out.print("null");
        }
        System.out.println();
    }
    static void test3() {
        String s = "";
        char[] string = s.toCharArray();
        string = replaceBlacks(string, s.length());
        for(char c : string)
            System.out.print(c);
        System.out.println();
    }
    static void test4() {
        String s = " ";
        char[] string = s.toCharArray();
        string = replaceBlacks(string, s.length());
        for(char c : string)
            System.out.print(c);
        System.out.println();
    }
    static void test5() {
        String s = "We      are";
        char[] string = s.toCharArray();
        string = replaceBlacks(string, s.length());
        for(char c : string)
            System.out.print(c);
        System.out.println();
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
