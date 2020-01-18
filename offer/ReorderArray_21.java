package offer;

import java.util.Arrays;

public class ReorderArray_21 {
    @FunctionalInterface
    interface ReorderFunc{
        boolean ReorderOddEven(int num);
    }
    public static void reorder(int[] array, ReorderFunc func) {
        if(array == null || array.length == 0) {
            return;
        }
        int before = 0;
        int after = array.length - 1;
        while (before < after) {
            while (before < after && !func.ReorderOddEven(array[before])) {
                before++;
            }
            while (before < after && func.ReorderOddEven(array[after])) {
                after--;
            }

            if(before < after) {
                int temp = array[before];
                array[before] = array[after];
                array[after] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reorder(array, num -> (num & 1) == 0);
        System.out.println(Arrays.toString(array));
    }
}
