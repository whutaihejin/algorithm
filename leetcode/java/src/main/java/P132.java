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

    // Time Limit Exceeded
    public int minCut(String s) {
        if (s.isEmpty()) return 0;
        int size = s.length();
        int[][] matrix = new int[size][size];
        for (int k = 0; k < size; k++) {
            matrix[k][k] = 0;
        }
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i <= size - len; i++) {
                int limit = i + len - 1;
                if (!isPalindrome(s, i, limit)) {
                    int minCut = Integer.MAX_VALUE;
                    for (int k = i; k < limit; k++) {
                        minCut = Math.min(minCut, matrix[i][k] + matrix[k + 1][limit] + 1);
                    }
                    matrix[i][limit] = minCut;
                }
            }
        }
        return matrix[0][size - 1];
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
        Assert.assertEquals(0, minCut(""));
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
