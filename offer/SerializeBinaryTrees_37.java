package offer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SerializeBinaryTrees_37 {
    public void serialize(TreeNode root, OutputStream ostream) throws IOException {
        if (ostream == null) {
            throw new IOException();
        }
        PrintStream stream = new PrintStream(ostream);
        if (root == null) {
            stream.println('$');
            return;
        }
        stream.println(root.val);
        serialize(root.left, ostream);
        serialize(root.right, ostream);
    }

    public TreeNode deserialize(Scanner scanner, TreeNode root) throws IOException {
        Integer number = readStream(scanner);
        if (number != null) {
            TreeNode node = new TreeNode(number);
            // 传参时, root直接传null
            if (root == null) {
                root = node;
            }
            root.left = deserialize(scanner, root.left);
            root.right = deserialize(scanner, root.right);
        }
        return root;
    }

    private Integer readStream(Scanner scanner) throws IOException {
        Integer res = -1;
        if(scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            if ("$".equals(nextLine)) {
                return null;
            } else {
                res = Integer.parseInt(nextLine);
            }
        }
        return res;
    }

}
