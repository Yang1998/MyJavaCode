package offer;

public class MoreThanHalfNumber_39 {
    public int moreThanHalfNum(int[] numbers) {
        if(numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("参数异常!");
        }
        int res = numbers[0];
        int times = 1;
        for (int number : numbers) {
            if (times == 0) {
                res = number;
                times = 1;
            } else if (number == res) {
                times++;
            } else {
                times--;
            }
        }
        if(!check(numbers, res)) {
            throw new IllegalArgumentException("参数异常!");
        }
        return res;
    }

    private boolean check(int[] numbers, int res) {
        int cnt = 0;
        for (int number : numbers) {
            if(number == res) {
                cnt++;
            }
        }
        return 2 * cnt > numbers.length;
    }
}
