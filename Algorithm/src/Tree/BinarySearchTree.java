package Tree;

import Tree.EmptyTreeException;

import java.util.*;

/*
方法：
    boolean add(char c)
    boolean remove(char c)
    boolean contains(char c)
    char max();
    char min();
    int size();
    int depth();
    BinarySearchTree buildTree(String preOrder, String inOrder)
遍历：
    List<Character> preOrder()
    List<Character> inOrder();
    List<Character> postOrder();
    List<Character> levelOrder();
 */
public class BinarySearchTree {
    // 属性
    private TreeNode root;
    int size;

    private static class TreeNode {
        TreeNode left;
        char val;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    // 构造方法

    //  boolean add(char c)
    public boolean add(char c) {
        // 递归
        int temp = size;
        root = add(root, c);
        return temp < size;

        // 循环添加
        /*if (root == null) {
            root = new TreeNode(c);
            size++;
            return true;
        }
        TreeNode parent = null;
        TreeNode node = root;
        int cmp = 0;
        while (node != null) {
            cmp = c - node.val;
            if (cmp > 0) {
                parent = node;
                node = node.right;
            } else if (cmp < 0) {
                parent = node;
                node = node.left;
            } else {
                return false;
            }
        }
        // 这就是要插入的位置
        if (cmp > 0) {
            parent.right = new TreeNode(c);
        } else {
            parent.left = new TreeNode(c);
        }
        size++;
        return true;*/
    }

    // char max();
    public char max() {
        // 递归
        if(root == null) {
            throw new EmptyTreeException();
        }
        return getMaxNode(root).val;
        // 循环
        /*if(root == null) {
            throw new EmptyTreeException();
        }
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;*/
    }

    private TreeNode getMaxNode(TreeNode node) {
        if(node.right == null) return node;
        return getMaxNode(node.right);
    }

    private TreeNode add(TreeNode node, char c) {
            if(node == null) {
                size++;
                return new TreeNode(c);
            }
            int cmp = c - node.val;
            if(cmp > 0) {
                node.right = add(node.right, c);
            } else if (cmp < 0 ) {
                node.left = add(node.left, c);
            }
            return node;
    }

    // boolean remove(char c)
    public boolean remove(char c) {
        // 递归
        if (root == null) {
            throw new EmptyTreeException();
        }
        int temp = size;
        root = remove(root, c);
        return temp > size;

        // 循环
        /*if (root == null) {
            throw new EmptyTreeException();
        }
        TreeNode parent = null;
        TreeNode node = root;
        do {
            int cmp = c - node.val;
            if (cmp < 0) {
                parent = node;
                node = node.left;
            } else if (cmp > 0){
                parent = node;
                node = node.right;
            }
        } while (node != null && node.val != c);
        // 没有找到这个元素
        if (node == null) return false;
        // 度为2的节点
        if (node.left != null && node.right != null) {
            // 找左子树的最大节点
            TreeNode pp = node;
            TreeNode p = node.left;
            while (p.right != null) {
                pp = p;
                p = p.right;
            }
            node.val = p.val;
            parent = pp;
            node = p;
        }
        // 度为0或者度为1
        TreeNode child = node.left != null ? node.left : node.right;
        if(parent == null) {
              root = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        size--;
        return true;*/
    }

    private TreeNode remove(TreeNode node, char c) {
        // 边界条件
        if (node == null) {
            return null;
        }
        int cmp = c - node.val;
        if (cmp < 0) {
            node.left = remove(node.left, c);
        } else if(cmp > 0) {
            node.right = remove(node.right, c);
        } else {
            if(node.left != null && node.right != null) {
                TreeNode minOfRight = getMinNode(node.right);
                node.val = minOfRight.val;
                node.right = remove(node.right, minOfRight.val);
            } else {
                size--;
                return node.left != null ? node.left : node.right;
            }
        }
        return node;
    }
    // min()
    public char min() {
        if(root == null) {
            throw new EmptyTreeException();
        }
        return getMinNode(root).val;
        /*if(root == null) {
            throw new EmptyTreeException();
        }
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;*/
    }

    private TreeNode getMinNode(TreeNode node) {
        if(node.left == null) return node;
        return getMinNode(node.left);
    }

    // boolean contains(char c)
    public boolean contains(char c) {
        // 递归
        if (root == null) {
            throw new EmptyTreeException();
        }

        return contains(root, c);

        // 循环
        /*if (root == null) {
            throw new EmptyTreeException();
        }
        TreeNode node = root;
        do {
            int cmp = c - node.val;
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return true;
            }
        } while (node != null);
        return false;*/
    }

    private boolean contains(TreeNode node, char c) {
        if (node == null) return false;
        int cmp = c - node.val;
        if (cmp < 0) return contains(node.left, c);
        else if(cmp > 0) return contains(node.right, c);
        return true;
    }

    // int size()
    public int size() {
        return size;
    }

    /*int depth()
    size = 0, depth = 0;
    size = 1, depth = 1;
    */
    public int depth() {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
        // return depth(root);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static BinarySearchTree buildTree(String inOrder, String postOrder) {
        int n = inOrder.length();
        BinarySearchTree res = new BinarySearchTree();
        res.root = buildTree(inOrder, 0, n - 1, postOrder, 0, n - 1);
        return res;
    }

    public static void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    private static TreeNode buildTree(String inOrder, int inl, int inr, String postOrder, int postl, int postr) {
        if(inl <= inr && postl <= postr) {
            char rootVal = postOrder.charAt(postr);
            int i;
            for (i = inl; i <= inr; i++) {
                if (inOrder.charAt(i) == rootVal) {
                    break;
                }
            }
            int cnt = i - inl;
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(inOrder, inl, i - 1, postOrder, postl, postl + cnt - 1);
            root.right = buildTree(inOrder, i + 1, inr, postOrder, postl + cnt, postr - 1);
            return root;
        }
        return null;
    }

    public List<List<Character>> levelOrder() {
        List<List<Character>> res = new ArrayList<>(new ArrayList<>());
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Character> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Character>> levelOrderReverse() {
        LinkedList<List<Character>> res = new LinkedList<>(new LinkedList<>());
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Character> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.addFirst(list);
        }
        return res;
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add('B');
        tree.add('A');
        tree.add('D');
        tree.add('C');
        tree.add('E');

        /*System.out.println(tree.size);
        System.out.println(tree.root.val);
        System.out.println(tree.add('C'));
        System.out.println(tree.size);
        System.out.println(tree.add('X'));
        System.out.println(tree.size);*/

        // System.out.println(tree.remove('B'));
        /*System.out.println(tree.remove('X'));
        System.out.println(tree.root.val);
        System.out.println(tree.root.right.val);
        System.out.println(tree.size);*/

        // contains(char c)
        // System.out.println(tree.contains('A'));
        // System.out.println(tree.contains('Z'));

        // max();
        // System.out.println(tree.max());
        // System.out.println(tree.min());

        // depth();
        // System.out.println(tree.depth());
        // tree.add('X');
//        System.out.println(tree.depth());
        inOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
        BinarySearchTree bst = buildTree("ABCDE", "ACEDB");
        System.out.println();
        inOrder(bst.root);
        System.out.println();
        postOrder(bst.root);
        System.out.println();
        System.out.println(tree.levelOrder());
        System.out.println(tree.levelOrderReverse());
    }

}
