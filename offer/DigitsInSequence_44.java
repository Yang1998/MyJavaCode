package offer;

public class DigitsInSequence_44 {
    /**
     * 返回n位数的数字有多少个
     * 比如： 1位数的数字有是个， 2位数的数字有90个，3位数的数字有900个
     * @param digit n位数
     * @return n位数对应数字的个数
     */
    private int countOfIntegers(int digit) {
        if(digit <= 0) {
            throw new IllegalArgumentException("参数最小为1");
        }
        if(digit == 1) {
            return 10;
        }
        int cnt = (int) Math.pow(10, digit - 1);
        return 9 * cnt;
    }

    /**
     * 返回在index处的数
     * @param digit n位数
     * @param index index
     * @return 在digit位数的限制下，index处的数字
     */
    private int digitAtIndex(int digit, int index) {
        int number = beginNumber(digit) + index / digit;
        int indexFromRight = digit - index % digit;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * 返回n位数字开始时的数字，比如1位数从0开始，2位数从10开始...
     * @param digit n位数
     * @return 开始的数字
     */
    private int beginNumber(int digit) {
        if(digit <= 0) {
            throw new IllegalArgumentException("参数最小为1");
        }
        if(digit == 1) {
            return 0;
        }
        return (int) Math.pow(10, digit - 1);
    }

    public int digitAtIndex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("index不能为负数！");
        }
        int digit = 1;
        while (true) {
            int num = countOfIntegers(digit);
            if(index < digit * num) {
                return digitAtIndex(digit, index);
            }
            index -= digit * num;
            digit++;
        }
    }
}
