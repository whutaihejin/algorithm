import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-4.
 */
public class P65 {

    // 方法待修改：有穷状态自动机
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        s = s.trim();
        boolean hasSign = false;
        boolean hasDot = false;
        int index = 0;
        for (; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == '+' || ch == '-') {
                if (!hasSign) {
                    hasSign = true;
                    continue;
                } else {
                    return false;
                }
            }
            if (ch == '.') {
                if (!hasDot) {
                    hasDot = true;
                    continue;
                } else {
                    return false;
                }
            }
            if (Character.isDigit(ch)) {
                continue;
            } else {
                if (ch == 'e' || ch == 'E') {
                    hasSign = false;
                    hasDot = false;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, isNumber("0"));
        Assert.assertEquals(true, isNumber(" 0.1 "));
        Assert.assertEquals(false, isNumber("abc"));
        Assert.assertEquals(false, isNumber("1 a"));
        Assert.assertEquals(true, isNumber("2e10"));
        Assert.assertEquals(true, isNumber("e10"));
    }
}
