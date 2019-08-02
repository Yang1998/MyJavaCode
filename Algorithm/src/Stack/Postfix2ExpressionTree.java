package Stack;

import java.util.Stack;

class ETree {
    String val;
    ETree  left;
    ETree  right;

    ETree(String val) {
        this.val = val;
    }
}

public class Postfix2ExpressionTree {


    private static String[] postfix;
    public static ETree toExpressiontree(String s) {
        postfix = Infix2Postfix.toPostfix(s);
        Stack<ETree> stack = new Stack<>();
        for (String ss:
             postfix) {
            if(!Infix2Postfix.isOper(ss)) {
                stack.add(new ETree(ss));
            }
            else {
                ETree rnode = stack.pop();
                ETree lnode = stack.pop();
                ETree opNode = new ETree(ss);
                opNode.left = lnode;
                opNode.right = rnode;
                stack.add(opNode);
            }
        }
        return stack.peek();
    }

    public static String expressionTree2Infix(ETree root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private static void helper(ETree root, StringBuilder sb) {
        if(root == null)
            return;
        helper(root.left, sb);
        if(Infix2Postfix.isOper(root.val))
            sb.append(" " + root.val + " ");
        else
            sb.append(root.val);
        helper(root.right, sb);

    }
    public static void main(String[] args) {
        String s = "1*2+3-4^2";
        System.out.println(expressionTree2Infix(toExpressiontree(s)));
    }
}
