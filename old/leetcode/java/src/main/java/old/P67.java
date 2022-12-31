package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P67 {

    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i, j;
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int val = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            builder.append(val % 2);
            carry = val / 2;
        }
        for (; i >=0; i--) {
            int val = a.charAt(i) - '0' + carry;
            builder.append(val % 2);
            carry = val / 2;
        }
        for (; j >= 0; j--) {
            int val = b.charAt(j) - '0' + carry;
            builder.append(val % 2);
            carry = val / 2;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        builder.reverse();
        return builder.toString();
    }

    @Test
    public void test0() {
        Assert.assertEquals(null, addBinary(null, null));
        Assert.assertEquals("", addBinary(null, ""));
        Assert.assertEquals("1", addBinary(null, "1"));
        Assert.assertEquals("1", addBinary("1", null));
    }

    @Test
    public void test1() {
        Assert.assertEquals("0", addBinary("0", "0"));
        Assert.assertEquals("1", addBinary("1", "0"));
        Assert.assertEquals("10", addBinary("1", "1"));
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals("110", addBinary("100", "10"));
    }
}
