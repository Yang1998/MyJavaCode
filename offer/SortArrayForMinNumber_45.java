package offer;

import java.util.Arrays;

public class SortArrayForMinNumber_45 {
    void printMinNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0) {
            return;
        }
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strNumbers, (o1, o2) -> {
            String mn = o1 + o2;
            String nm = o2 + o1;
            return mn.compareTo(nm);
        });
        for (String strNumber : strNumbers) {
            System.out.print(strNumber);
        }
        System.out.println();
    }
}
