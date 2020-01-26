package offer;

public class NumericStrings_20 {
    // 数字格式为  A[.[B]][e|EC] or .B[e|EC] A和C均为整数，B为无符号整数
    public static boolean isNumeric(String str) {
        if(str == null || "".equals(str)) {
            return false;
        }
        return isNumeric(new StringBuilder(str.trim()));
    }

    private static boolean isNumeric(StringBuilder str) {
        boolean numeric = scanInteger(str);

        if(str.length() > 0 && str.charAt(0) == '.') {
            str.deleteCharAt(0);
            numeric = scanUnsignedInteger(str) || numeric;
        }

        if(str.length() > 0 &&  (str.charAt(0) == 'e' || str.charAt(0) == 'E')) {
            str.deleteCharAt(0);
            numeric = numeric && scanInteger(str);
        }

        return numeric && str.length() == 0;
    }

    // 扫描 A or C
    private static boolean scanUnsignedInteger(StringBuilder str) {
        final int beforeSize = str.length();
        while (str.length() > 0 && '0' <= str.charAt(0) && str.charAt(0) <= '9') {
            str.deleteCharAt(0);
        }
        return beforeSize > str.length();
    }

    // 扫描 B
    private static boolean scanInteger(StringBuilder str) {
        if(str.length() > 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
            str.deleteCharAt(0);
        }
        return scanUnsignedInteger(str);
    }


    public static void main(String[] args) {
        //true
        System.out.println(isNumeric("+100"));
        System.out.println(isNumeric("5e2"));
        System.out.println(isNumeric("-123"));
        System.out.println(isNumeric("3.1416"));
        System.out.println(isNumeric(".123"));
        // false
        System.out.println(isNumeric("12e"));
        System.out.println(isNumeric("1a1234"));
        System.out.println(isNumeric("1.2.4"));
    }
}
