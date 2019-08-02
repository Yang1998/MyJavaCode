//package Algs4;
//
//import edu.princeton.cs.algs4.StdDraw;
//import edu.princeton.cs.algs4.StdRandom;
//
//public class visualSort {
//    public static void main(String[] args) throws InterruptedException {
//        StdDraw.setCanvasSize(1000, 1000);
//        int N = 500;
//        double[] nums = new double[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = StdRandom.random();
//        }
////        qSort(nums, 0, N - 1);
//        mergeSort(nums, 0, N - 1);
//    }
//
//
//
//    private static void merge(double[] nums, int l, int mid, int r) throws InterruptedException {
//        double[] copy = new double[r - l + 1];
//        int index = 0;
//        int i = l, j = mid + 1;
//        while (i <= mid && j <= r) {
//            if(nums[i] <= nums[j]) copy[index++] = nums[i++];
//            else copy[index++] = nums[j++];
//        }
//        if(i <= mid) System.arraycopy(nums, i, copy, index, mid - i + 1);
//        if(j <= r) System.arraycopy(nums, j, copy, index, r - j + 1);
//        System.arraycopy(copy, 0, nums, l, r - l + 1);
//    }
//
//    public static void qSort(double[] nums, int l, int r) throws InterruptedException {
//        if(l < r) {
//            int i = l, j = r;
//            double num = nums[i];
//            while (i < j) {
//                while (i < j && num <= nums[j]) j--;
//                nums[i] = nums[j];
//                draw(nums);
//                while (i < j && nums[i] <= num) i++;
//                nums[j] = nums[i];
//                draw(nums);
//            }
//            nums[i] = num;
//            draw(nums);
//            qSort(nums, l, i - 1);
//            qSort(nums, i + 1, r);
//        }
//    }
//
//
//    public static void draw(double[] nums) throws InterruptedException {
//        StdDraw.clear();
//        StdDraw.enableDoubleBuffering();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            double x = i * 1.0 / n;
//            double y = nums[i] / 2.0;
//            double rw = 0.5 / n;
//            double rh = nums[i] / 2.0;
//            StdDraw.filledRectangle(x, y, rw, rh);
//        }
//        StdDraw.show();
//        StdDraw.pause(15);
//    }
//}
