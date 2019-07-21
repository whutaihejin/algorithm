package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-17.
 */
public class P151 {

    private static final char CHAR_SPACE = ' ';

    private void revese(char[] buf, int low, int high) {
        for (; low < high; low++, high--) {
            buf[low] = (char)(buf[low] ^ buf[high]);
            buf[high] = (char)(buf[low] ^ buf[high]);
            buf[low] = (char)(buf[low] ^ buf[high]);
        }
    }

    public String reverseWords(String s) {
        char[] buf = s.toCharArray();
        int limit = buf.length - 1;
        for (; limit >= 0 && buf[limit] == CHAR_SPACE;) limit--;
        int i = 0, j = 0;
        // 预处理
        for (; j <= limit;) {
            for (; j <= limit && buf[j] == CHAR_SPACE;) j++;
            for (; j <= limit; i++, j++) {
                buf[i] = buf[j];
                if (buf[j] == CHAR_SPACE) {
                    i++; j++;
                    break;
                }
            }
        }
        // reverse every word
        limit = i;
        i = 0;
        for (; i < limit;) {
            j = i;
            while (j < limit && buf[j] != CHAR_SPACE) j++;
            revese(buf, i, j - 1);
            i = j + 1;
        }
        // reverse whole string
        revese(buf, 0, limit - 1);
        return new String(buf, 0, limit);
    }

    @Test
    public void test0() {
        Assert.assertEquals("", reverseWords(""));
        Assert.assertEquals("", reverseWords("   "));
        Assert.assertEquals("abc", reverseWords("abc"));
        Assert.assertEquals("abc", reverseWords("  abc"));
        Assert.assertEquals("abc", reverseWords("abc   "));
        Assert.assertEquals("abc", reverseWords("   abc   "));
    }

    @Test
    public void test1() {
        char[] buf = "abc".toCharArray();
        revese(buf, 0, buf.length - 1);
        Assert.assertEquals("cba", new String(buf));
    }

    @Test
    public void test2() {
        Assert.assertEquals("", reverseWords(""));
        Assert.assertEquals("", reverseWords("    "));
        Assert.assertEquals("abc", reverseWords("abc"));
        Assert.assertEquals("abc", reverseWords("   abc"));
        Assert.assertEquals("abc", reverseWords("abc   "));
        Assert.assertEquals("abc", reverseWords("   abc   "));
        Assert.assertEquals("sky the", reverseWords("the sky"));
        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
        Assert.assertEquals("blue is sky the", reverseWords("   the     sky is blue    "));
    }
}
