import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-19.
 */
public class P58 {

    public int lengthOfLastWord(String s) {
        int length = 0;
        if (s == null || s.isEmpty()) {
            return length;
        }
        char space = ' ';
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == space) tail--;
        int low = -1;
        int index = 0;
        for (; index <= tail; index++) {
            if (s.charAt(index) == space) {
                low = index;
            }
        }
        return Math.max(0, index - low - 1);
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, lengthOfLastWord(""));
        Assert.assertEquals(0, lengthOfLastWord("  "));
        Assert.assertEquals(0, lengthOfLastWord("      "));
        Assert.assertEquals(1, lengthOfLastWord("   a   "));
        Assert.assertEquals(3, lengthOfLastWord("   a   aaa"));
        Assert.assertEquals(5, lengthOfLastWord("Hello World"));
        Assert.assertEquals(5, lengthOfLastWord("    Hello   World   "));
        Assert.assertEquals(5, lengthOfLastWord("World"));
        Assert.assertEquals(1, lengthOfLastWord("a"));
    }

}
