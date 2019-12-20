package leetcode;
/*
利用递减栈
在栈里存索引值，满足后进入的数比先进入的小
如果T[i]>=T[stack.peek()]则一直弹出栈顶元素，如果弹出结束，判断栈是否为空，如果是空，则说明在此天后面，
没有温度比他高的索引，否则用栈顶元素减去i。
 */
import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = T.length - 1; i >= 0; --i) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = 0;
            }
            else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }
}
