package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-9.
 */
public class P136 {

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, singleNumber(new int[]{}));
        Assert.assertEquals(0, singleNumber(new int[]{0}));
        Assert.assertEquals(1, singleNumber(new int[]{1}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, singleNumber(new int[]{1, 1, 2}));
        Assert.assertEquals(1, singleNumber(new int[]{1, 2, 2}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5}));
        Assert.assertEquals(6, singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6}));
    }
}
