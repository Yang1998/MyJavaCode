package offer;

public class SequenceOfBST_33 {
    public static boolean verifySequenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        int i = 0;
        for (; i < sequence.length - 1; i++) {
            if(sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < sequence.length - 1; j++) {
            if(sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
            if(i > 0) {
            int[] leftArray = new int[i];
            System.arraycopy(sequence, 0, leftArray, 0, i);
            left = verifySequenceOfBST(leftArray);
        }
        boolean right = true;
        if(i < sequence.length - 1) {
            int[] rightArray = new int[sequence.length - 1 - i];
            System.arraycopy(sequence, i, rightArray, 0, sequence.length - 1 - i);
            right = verifySequenceOfBST(rightArray);
        }
        return left && right;
    }
}
