package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-9.
 */
public class P132 {

    private boolean isPalindrome(String s, int low, int high) {
        for (; low < high; low++, high--) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
        }
        return true;
    }

    public int minCut(String s) {
        int size = s.length();
        int[] cut = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; i - j >= 0 && i + j < size && s.charAt(i - j) == s.charAt(i + j); j++) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
            }
            for (int j = 1; i - j + 1 >= 0 && i + j < size && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j + 1] + 1);
            }
        }
        return cut[size];
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, isPalindrome("1", 0, 0));
        Assert.assertEquals(true, isPalindrome("11", 0, 1));
        Assert.assertEquals(true, isPalindrome("111", 0, 2));
        Assert.assertEquals(false, isPalindrome("112", 0, 2));
        Assert.assertEquals(false, isPalindrome("12", 0, 1));
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, minCut("aab"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, minCut(""));
        Assert.assertEquals(0, minCut("a"));
        Assert.assertEquals(0, minCut("aa"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, minCut("ab"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, minCut("aaaabbbb"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(1, minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
