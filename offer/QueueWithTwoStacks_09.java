package offer;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithTwoStacks_09 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static int pop() {
        if(stack1.isEmpty()) {
            throw new NoSuchElementException();
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

    public static void push(int val) {
        stack1.push(val);
    }
}
