import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by taihejin on 16-8-9.
 */
public class P137 {

    private int[] count = new int[32];
    private static final int DUPLICATE_TIME = 3;

    public int singleNumber(int[] nums) {
        Arrays.fill(count, 0);
        for (int num : nums) {
            for (int i = 0; num != 0; i++, num >>>= 1) {
                count[i] += (num & 0x01);
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                ret |= (1 << i);
            }
        }
        return ret;
    }

    public void bitCount(int[] count, int num) {
        for (int offset = 0; num != 0; offset++, num >>>= 1) {
            count[offset] += (num & 0x01);
        }
    }

    @Test
    public void test0() {
        int[] count = new int[32];
        bitCount(count, 2);
        Assert.assertEquals("[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", Arrays.toString(count));
    }

    @Test
    public void test1() {
        int[] count = new int[32];
        bitCount(count, 0x7FFFFFFF);
        Assert.assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]", Arrays.toString(count));
    }

    @Test
    public void test2() {
        int[] count = new int[32];
        bitCount(count, 0xFFFFFFFF);
        Assert.assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", Arrays.toString(count));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, singleNumber(new int[]{1}));
        Assert.assertEquals(2, singleNumber(new int[]{2}));
        Assert.assertEquals(0, singleNumber(new int[]{0}));
        Assert.assertEquals(-1, singleNumber(new int[]{-1}));
        Assert.assertEquals(-2, singleNumber(new int[]{-2}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, singleNumber(new int[]{1, 2, 2, 2}));
        Assert.assertEquals(1, singleNumber(new int[]{1, 2, 2, 2, 3, 3, 3}));
        Assert.assertEquals(6, singleNumber(new int[]{2, 2, 2, 3, 3, 3, 6}));
        Assert.assertEquals(0, singleNumber(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 0}));
        Assert.assertEquals(-1, singleNumber(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, -1}));
        Assert.assertEquals(-2, singleNumber(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, -2}));
    }
}
