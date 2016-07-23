import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by taihejin on 16-7-22.
 */

public class P87 {

    @Test
    public void test3() {
        Assert.assertEquals(true, isScramble("a", "a"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(true, isScramble("ab", "ab"));
        Assert.assertEquals(true, isScramble("ab", "ba"));
        Assert.assertEquals(true, isScramble("abc", "abc"));
        Assert.assertEquals(true, isScramble("abc", "acb"));
        Assert.assertEquals(true, isScramble("abc", "cba"));
        Assert.assertEquals(true, isScramble("abc", "bac"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int size = s1.length();
        boolean[][][] state = new boolean[size][size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                state[0][r][c] = (s1.charAt(r) == s2.charAt(c));
            }
        }
        for (int l = 1; l < size; l++) {
            for (int i = size - l - 1; i >= 0; i--) {
                for (int j = size - l - 1; j >= 0; j--) {
                    for (int k = 0; k < l; k++) {
                        if ((state[k][i][j] && state[l - k - 1][i + k + 1][j + k + 1])
                                || (state[k][i][j + l - k] && state[l - k - 1][i + k + 1][j])) {
                            state[l][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return state[size - 1][0][0];
    }

    public boolean isScrambleRecursive(String s1, String s2) {
         System.out.println(String.format("call -> %s %s", s1, s2));
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        if (!Arrays.equals(arr1, arr2)) {
            return false;
        }
        boolean scramble = false;
        for (int i = 1; i < s1.length(); i++) {
            scramble = isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
            if (!scramble) {
                scramble = isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length())) &&
                        isScramble(s1.substring(s1.length() - i, s1.length()), s2.substring(0, i));
            }
            if (scramble) {
                break;
            }
        }
        return scramble;
    }

    @Test
    public void test0() {
        String str = "abc";
        for (int i = 1; i < str.length(); i++) {
            System.out.println(str.substring(0, i) + " - " + str.substring(i, str.length()));
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, isScramble("a", "a"));
        Assert.assertEquals(false, isScramble("a", "b"));
        Assert.assertEquals(true, isScramble("ab", "ab"));
        Assert.assertEquals(true, isScramble("ab", "ba"));
        Assert.assertEquals(true, isScramble("abc", "abc"));
        Assert.assertEquals(true, isScramble("abc", "acb"));
        Assert.assertEquals(true, isScramble("abc", "bac"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(true, isScramble("great", "rgeat"));
        Assert.assertEquals(true, isScramble("great", "rgtae"));
    }

}
