/**
 * Created by taihejin on 16-7-24.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P93 {

    private boolean valid(String str) {
        if (str.length() == 1) return true;
        if (str.startsWith("0") || str.length() > 3) return false;
        long val = 0;
        for (int low = 0; low < str.length(); low++) {
            val = val * 10 + str.charAt(low) - '0';
        }
        return val > 255 ? false : true;
    }

    private String build(String s, int i, int j, int k) {
        StringBuilder builder = new StringBuilder();
        for (int l = 0; l < s.length(); l++) {
            builder.append(s.charAt(l));
            if (l == i || l == j || l == k) {
                builder.append('.');
            }
        }
        return builder.toString();
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        int size = s.length();
        for (int i = 0; i < Math.min(3, size); i++) {
            if (!valid(s.substring(0, i + 1))) continue;
            for (int j = i + 1; j < Math.min(i + 4, size); j++) {
                if (!valid(s.substring(i + 1, j + 1))) continue;
                for (int k = j + 1; k < Math.min(j + 4, size); k++) {
                    if (!valid(s.substring(j + 1, k + 1)) || k + 1 > size - 1) continue;
                    if (valid(s.substring(k + 1, size))) {
                        ret.add(build(s, i, j, k));
                    }
                }
            }
        }
        return ret;
    }

    @Test
    public void test0() {
        Assert.assertEquals(2, restoreIpAddresses("25525511135").size());
        Assert.assertEquals(1, restoreIpAddresses("1111").size());
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, valid("12"));
        Assert.assertEquals(true, valid("255"));
        Assert.assertEquals(false, valid("256"));
        Assert.assertEquals(true, valid("0"));
        Assert.assertEquals(false, valid("011"));
    }

    @Test
    public void test2() {
        String s = "010010";
        Assert.assertEquals(2, restoreIpAddresses(s).size());
    }

    @Test
    public void test3() {
        Assert.assertEquals(false, new String("0").matches("0\\d+"));
        Assert.assertEquals(true, new String("01").matches("0\\d+"));
    }
}
