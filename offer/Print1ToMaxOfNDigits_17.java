package offer;

public class Print1ToMaxOfNDigits_17 {
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if(index == length - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    private static void printNumber(char[] number) {
        boolean isStartWith0 = true;
        int n = number.length;
        for (int i = 0; i < n; i++) {
            if (isStartWith0 && number[i] != '0') {
                isStartWith0 = false;
            }
            // 如果不是以0开头，则打印
            if (!isStartWith0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(15);
    }
}
