package offer;

import java.util.Stack;

public class StackPushPopOrder_31 {
    public boolean isPopOrder(int[] push, int[] pop) {
        boolean res = false;
        if(push == null || pop == null || push.length != pop.length) {
            return res;
        }
        int pushIndex = 0, popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (popIndex < pop.length) {
            while (stack.empty() || stack.peek() != pop[popIndex]) {
                if(pushIndex == push.length) {
                    break;
                }
                stack.push(push[pushIndex++]);
            }
            if(stack.peek() != pop[popIndex]) {
                break;
            }
            stack.pop();
            popIndex++;
        }
        if(stack.empty() && popIndex == pop.length) {
            res = true;
        }
        return res;
    }
}
