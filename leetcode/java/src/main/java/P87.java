import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by taihejin on 16-7-22.
 */

public class P87 {

    public boolean isScramble(String s1, String s2) {
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
