import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-25.
 */

public class P97 {

    public boolean doInterleave(String s1, int l1,
                                String s2, int l2,
                                String s3, int l3) {
        if (l3 >= s3.length()) {
            return true;
        } else if (l1 >= s1.length()) {
            return s2.substring(l2).equals(s3.substring(l3));
        } else if (l2 >= s2.length()) {
            return s1.substring(l1).equals(s3.substring(l3));
        }
        char ch = s3.charAt(l3);
        if (ch == s1.charAt(l1)) {
            if (ch == s2.charAt(l2)) {
                return doInterleave(s1, l1 + 1, s2, l2, s3, l3 + 1) ? true : doInterleave(s1, l1, s2, l2 + 1, s3, l3 + 1);
            } else {
                return doInterleave(s1, l1 + 1, s2, l2, s3, l3 + 1);
            }
        } else if (ch == s2.charAt(l2)) {
            return doInterleave(s1, l1, s2, l2 + 1, s3, l3 + 1);
        } else {
            return false;
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty()) return s2.equals(s3);
        if (s2.isEmpty()) return s1.equals(s3);
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] state = new boolean[s1.length() + 1][s2.length() + 1];
        boolean flag = true;
        for (int k = 0; k < s2.length(); k++) {
            state[0][k + 1] = s2.charAt(k) == s3.charAt(k) ? flag : (flag = false);
        }
        flag = true;
        for (int k = 0; k < s1.length(); k++) {
            state[k + 1][0] = s1.charAt(k) == s3.charAt(k) ? flag : (flag = false);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                boolean valid = false;
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    valid = state[i - 1][j];
                }
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && !valid) {
                    valid = state[i][j - 1];
                }
                state[i][j] = valid;
            }
        }
        return state[s1.length()][s2.length()];
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, isInterleave("abc", "", "abc"));
        Assert.assertEquals(true, isInterleave("", "abc", "abc"));
        Assert.assertEquals(true, isInterleave("", "", ""));
        Assert.assertEquals(true, isInterleave("abc", "de", "adbce"));
    }
    @Test
    public void test1() {
        Assert.assertEquals(true, isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assert.assertEquals(false, isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
