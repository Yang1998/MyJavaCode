package Sorting;
import java.util.Arrays;
import java.util.Random;

public class Test {


//    private static final int N = 50000;
    public static void main(String[] args) {
        for (int N = 100; N <= 100000; N *= 10) {
            int[] nums = new int[N];
            Random random = new Random();
            for (int i = 0; i < N; i++) {
                nums[i] = random.nextInt(N * 10);
            }
            Long start = 0L, end = 0L;
            int[] quickSortArray = Arrays.copyOf(nums, nums.length);
            int[] InsertSortArray = Arrays.copyOf(nums, nums.length);
            int[] shellSortArray = Arrays.copyOf(nums, nums.length);
            int[] bubbleSortArray = Arrays.copyOf(nums, nums.length);
            int[] selectionSortArray = Arrays.copyOf(nums, nums.length);
            int[] mergeSortArray = Arrays.copyOf(nums, nums.length);
            System.out.println("数据量为：" + N);
            start = System.currentTimeMillis();
            QuickSort.quickSort(quickSortArray, 0, N - 1);
            end = System.currentTimeMillis();
            System.out.println("快速排序运行时间" + 1.0 * (end - start) / 1000 + "s");
            start = System.currentTimeMillis();
            InsertSort.insertSort(InsertSortArray);
            end = System.currentTimeMillis();
            System.out.println("插入排序运行时间" + 1.0 * (end - start) / 1000 + "s");
            start = System.currentTimeMillis();
            ShellSort.shellSort(shellSortArray, 8);
            end = System.currentTimeMillis();
            System.out.println("希尔排序运行时间" + 1.0 * (end - start) / 1000 + "s");
            start = System.currentTimeMillis();
            BubbleSort.bubbleSort(bubbleSortArray);
            end = System.currentTimeMillis();
            System.out.println("冒泡排序运行时间" + 1.0 * (end - start) / 1000 + "s");
            start = System.currentTimeMillis();
            SelectionSort.selectionSort(selectionSortArray);
            end = System.currentTimeMillis();
            System.out.println("选择排序运行时间" + 1.0 * (end - start) / 1000 + "s");
            start = System.currentTimeMillis();
            MergeSort.mergeSort(mergeSortArray);
            end = System.currentTimeMillis();
            System.out.println("归并排序运行时间" + 1.0 * (end - start) / 1000 + "s");
        }
    }
}
