package leetcode;

import java.util.Stack;

public class Solution155 {
    class MinStack {
        Stack<Integer> valueStack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            valueStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            valueStack.push(x);
            if(minStack.isEmpty() || minStack.peek() >= x)
                minStack.push(x);
        }

        public void pop() {
            int val = valueStack.pop();
            if(val == minStack.peek())
                minStack.pop();
        }

        public int top() {
            return valueStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
