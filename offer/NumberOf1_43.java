package offer;

public class NumberOf1_43 {
    public int numberOf1Between1AndN(int n) {
        if(n <= 0) {
            return 0;
        }
        return numberOf1(Integer.toString(n));
    }

    private int numberOf1(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        int first = str.charAt(0) - '0';
        int len = str.length();
        if(len == 1 && first == 0) {
            return 0;
        }
        if(len == 1 && 0 < first && first <= 9) {
            return 1;
        }
        int numFirstDigit = 0;
        if(first > 1) {
            numFirstDigit = powerOf10(len - 1);
        } else {
            numFirstDigit = Integer.parseInt(str.substring(1)) + 1;
        }
        int numOtherDigits = first * (len - 1) * powerOf10(len - 2);
        int numRecursive = numberOf1(str.substring(1));
        return numFirstDigit + numOtherDigits + numRecursive;
    }

    private int powerOf10(int num) {
        return (int) Math.pow(10, num);
    }
}
