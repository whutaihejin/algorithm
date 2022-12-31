package old;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by taihejin on 16-8-1.
 */
public class P150 {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String token : tokens) {
            if (token.length() >= 2 || Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer right = stack.pop();
                Integer left = stack.pop();
                if (token.equals("+")) {
                    stack.push(left + right);
                } else if (token.equals("-")) {
                    stack.push(left - right);
                } else if (token.equals("*")) {
                    stack.push(left * right);
                } else if (token.equals("/")) {
                    stack.push(left / right);
                }
            }
        }
        return stack.pop();
    }

    @Test
    public void test0() {
        Assert.assertEquals(1, evalRPN(new String[]{"1"}));
        Assert.assertEquals(11, evalRPN(new String[]{"11"}));
        Assert.assertEquals(112, evalRPN(new String[]{"112"}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, evalRPN(new String[]{"3", "-4", "+"}));
    }
}
