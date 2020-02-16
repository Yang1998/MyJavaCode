package offer;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import static util.StringUtil.parseString2IntArray;

public class PathInTree_34 {
    private PrintStream stream;

    public PathInTree_34() {
        stream = System.out;
    }
    public PathInTree_34(OutputStream stream) {
        if (stream != null && !(stream instanceof PrintStream)) {
            this.stream = new PrintStream(stream, true);
        } else {
            this.stream = System.out;
        }
    }

    public void findPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        Deque<Integer> path = new LinkedList<>();
        int currentSum = 0;
        findPath(root, sum, path, currentSum);
    }

    private void findPath(TreeNode root, int sum, Deque<Integer> deque, int currentSum) {
        currentSum += root.val;
        deque.addLast(root.val);
        boolean isLeaf = isLeafNode(root);
        if (currentSum == sum && isLeaf) {
            stream.print("A path is found:");
            for (Integer integer : deque) {
                stream.print(integer + "\t");
            }
            stream.println();
        }
        if (root.left != null) {
            findPath(root.left, sum, deque, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, sum, deque, currentSum);
        }
        deque.removeLast();
    }

    private boolean isLeafNode(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("out.txt");
        PathInTree_34 pathInTree_34 = new PathInTree_34();
        Scanner scanner = new Scanner(new File("in.txt"));
        String preIn = scanner.nextLine();
        String inIn = scanner.nextLine();
        int[] preOrder = parseString2IntArray(preIn);
        int[] inOrder = parseString2IntArray(inIn);
        TreeNode tree = new ConstructBinaryTree_07().Construct(preOrder, inOrder);
        pathInTree_34.findPath(tree, 22);
    }
}
