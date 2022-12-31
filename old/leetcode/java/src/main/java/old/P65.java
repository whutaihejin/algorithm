package old;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by taihejin on 16-7-4.
 */

public class P65 {

    private enum InputType {SPACE, SIGN, DOT, DIGIT, EXPONENTIAL, OTHER};

    private int[][] transitionTable = {
            {0, 1, 3, 2, -1, -1}, // state 0
            {-1, -1, 3, 2, -1, -1}, // state 1
            {8, -1, 4, 2, 5, -1}, // state 2
            {-1, -1, -1, 4, -1, -1}, // state 3
            {8, -1, -1, 4, 5, -1}, // state 4
            {-1, 6, -1, 7, -1, -1}, // state 5
            {-1, -1, -1, 7, -1, -1}, // state 6
            {8, -1, -1, 7, -1, -1}, // state 7
            {8, -1, -1, -1, -1, -1}, // state 8
    };

    // 方法待修改：有穷状态自动机
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            InputType input = InputType.OTHER;
            switch (ch) {
                case ' ': input = InputType.SPACE; break;
                case '+':
                case '-': input = InputType.SIGN; break;
                case '.': input = InputType.DOT; break;
                case 'e':
                case 'E': input = InputType.EXPONENTIAL; break;
                default:
                    if (Character.isDigit(ch)) {
                        input = InputType.DIGIT;
                    }
            }
            state = transitionTable[state][input.ordinal()];
            if (state == -1) {
                return false;
            }
        }
        return state == 2 || state == 4 || state == 7 || state == 8;
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, isNumber("+12.51e-123"));
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, isNumber("0"));
        Assert.assertEquals(true, isNumber(" 0.1 "));
        Assert.assertEquals(false, isNumber("abc"));
        Assert.assertEquals(false, isNumber("1 a"));
        Assert.assertEquals(true, isNumber("2e10"));
        Assert.assertEquals(false, isNumber("e10"));
        Assert.assertEquals(true, isNumber("2."));
        Assert.assertEquals(true, isNumber("2.e12"));
        Assert.assertEquals(true, isNumber("  2.e12  "));
        Assert.assertEquals(true, isNumber(".2"));
        Assert.assertEquals(true, isNumber("   .2  "));
        Assert.assertEquals(true, isNumber("  .2e15  "));
        Assert.assertEquals(true, isNumber("  2123  "));
        Assert.assertEquals(true, isNumber("  2123.234  "));
        Assert.assertEquals(true, isNumber("  2123.234e+2324  "));
    }
}
