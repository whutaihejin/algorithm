import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-23.
 */
public class P91 {

    public int doNumDecoding(String s, int i) {
        if (i >= s.length() - 1) { return 1; }
        boolean valid = ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0') <= 26;
        return doNumDecoding(s, i + 1) + (valid ? doNumDecoding(s, i + 2) : 0);
    }

    public int numDecodingsRecursive(String s) {
        if (s.length() <= 1) return 1;
        return doNumDecoding(s, 0);
    }

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int low = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        int high = 1;
        for (int k = s.length() - 2; k >= 0; k--) {
            char curr = s.charAt(k);
            int val = (curr == '0' ? 0 : low + (((curr - '0') * 10 + s.charAt(k + 1) - '0') <= 26 ? high : 0));
            high = low;
            low = val;
        }
        return low;
    }

    @Test
    public void test0() {
        Assert.assertEquals(1, numDecodings("1"));
        Assert.assertEquals(1, numDecodings("6"));
        Assert.assertEquals(2, numDecodings("11"));
        Assert.assertEquals(2, numDecodings("16"));
        Assert.assertEquals(1, numDecodings("66"));
        Assert.assertEquals(3, numDecodings("121"));
        Assert.assertEquals(5, numDecodings("1213"));
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, numDecodings(""));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, numDecodings("0"));
        Assert.assertEquals(1, numDecodings("1"));
        Assert.assertEquals(2, numDecodings("11"));
        Assert.assertEquals(1, numDecodings("110"));
        Assert.assertEquals(0, numDecodings("00"));
        Assert.assertEquals(0, numDecodings("100"));
        Assert.assertEquals(0, numDecodings("1100"));
        Assert.assertEquals(0, numDecodings("1100111"));
        Assert.assertEquals(2, numDecodings("11011"));
        Assert.assertEquals(1, numDecodings("27"));
    }
}
