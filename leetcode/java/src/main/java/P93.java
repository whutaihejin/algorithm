/**
 * Created by taihejin on 16-7-24.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P93 {

    private long splitNumber(String s, int low, int high) {
        long val = 0;
        for (; low <= high; low++) {
            val = val * 10 + s.charAt(low) - '0';
        }
        return val;
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
            if (splitNumber(s, 0, i) > 255) continue;
            for (int j = i + 1; j < Math.min(i + 4, size); j++) {
                if (splitNumber(s, i + 1, j) > 255) continue;
                for (int k = j + 1; k < Math.min(j + 4, size); k++) {
                    if (splitNumber(s, j + 1, k) > 255 || k + 1 > size - 1) continue;
                    if (splitNumber(s, k + 1, size - 1) <= 255) {
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
        String s = "25525511135";
        Assert.assertEquals(2, splitNumber(s, 0, 0));
        Assert.assertEquals(25, splitNumber(s, 0, 1));
        Assert.assertEquals(255, splitNumber(s, 0, 2));
        Assert.assertEquals(55, splitNumber(s, 1, 2));
        Assert.assertEquals(552, splitNumber(s, 1, 3));
    }
}
