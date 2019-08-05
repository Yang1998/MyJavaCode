package Stack;

import java.util.*;

public class Infix2Postfix {
    /**
     * 判断一个字符串是否是操作符
     * @param s 字符串可能是操作数或者是操作符
     * @return
     */
    public static boolean isOper(String s) {
        String[] ss = {"+", "-", "*", "/", "(", ")", "^"};
        for(String s1 : ss) {
            if(s1.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将一个中缀表达式字符串转换成后缀表达式字符串数组
     * @param s 中缀表达式字符串,无视空白字符,支持幂操作
     * @return 后缀表达式字符串数组
     */

    public static String[] toPostfix(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        //设置优先级
        Map<String, Integer> priority = new HashMap<>();
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("^", 3);
        priority.put("(", Integer.MAX_VALUE);
        priority.put(")", Integer.MAX_VALUE);
        //预处理输入
        for(int i = 0; i < s.length(); ++i) {
            if(Character.isDigit(s.charAt(i))) {
                String tmp = "";
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    tmp += s.charAt(i++);
                }
                i--;
                arrayList.add(tmp);
            }
            else if(Character.isSpaceChar(s.charAt(i))) {
                continue;
            }
            else {
                arrayList.add("" + s.charAt(i));
            }
        }
        String[] infix = new String[arrayList.size()];
        infix = arrayList.toArray(infix);
        arrayList = new ArrayList<>();
        for(String ss : infix) {
            if(!isOper(ss)) {
                arrayList.add(ss);
            }
            else {
                if(stack.isEmpty() || ss.equals("(")) {
                    stack.add(ss);
                }
                else {
                    if(ss.equals(")")) {
                        while(!stack.isEmpty() && !stack.peek().equals("(")) {
                            arrayList.add(stack.pop());
                        }
                        if(!stack.isEmpty())
                            stack.pop(); //弹出"("
                    }
                    else {
                        if(priority.get(stack.peek()) >= priority.get(ss)) {
                            while (!stack.isEmpty() && !stack.peek().equals("(") && priority.get(stack.peek()) >= priority.get(ss)) {
                                arrayList.add(stack.pop());
                            }
                        }
                            stack.push(ss);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        String[] postfix = new String[arrayList.size()];
        return arrayList.toArray(postfix);
    }

     public static double helper(String[] postfix) {
        Stack<Double> stack = new Stack<>();
        for(String s : postfix) {
            if(!isOper(s)) {
                stack.add(1.0 * Integer.parseInt(s));
            }
            else {
                double numR = stack.pop();
                double numL = stack.pop();
                //java7前不支持switch(String)
                switch (s) {
                    case "+" : stack.push(numL + numR); break;
                    case "-" : stack.push(numL - numR); break;
                    case "*" : stack.push(numL * numR); break;
                    case "/" : stack.push(numL / numR); break;
                    case "^" : stack.push(Math.pow(numL, numR)); break;
                }
            }
        }
        return stack.peek();
    }

    public static double calc(String s) {
        return helper(toPostfix(s));
    }
    public static void main(String[] args) {
        String s = "6 * 12 / 6 ^ 2";
        System.out.println(Arrays.toString(toPostfix(s)));
        System.out.println(s + " = " + calc(s));
    }
}
