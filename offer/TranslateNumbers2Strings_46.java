package offer;

/**
 * 动态规划， 自底向上
 */
public class TranslateNumbers2Strings_46 {
    public int getTranslationCount(int number) {
        if(number < 0) {
            return 0;
        }
        return getTranslationCount(Integer.toString(number));
    }

    private int getTranslationCount(String strNumber) {
        int len = strNumber.length();
        int[] counts = new int[len];
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            count = 0;
            if(i < len - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }

            if(i < len - 1) {
                int digit1 = strNumber.charAt(i) - '0';
                int digit2 = strNumber.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if(10 <= converted && converted <= 25) {
                    if(i < len - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNumbers2Strings_46().getTranslationCount(12258));
    }
}
