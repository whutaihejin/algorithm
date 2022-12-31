package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-10.
 */
public class P135 {

    public int candy(int[] ratings) {
        int delta = 0, total = 0, candy = 0, index = 0, sharp = 0;
        long prev = -1L + Integer.MIN_VALUE;
        for (int k = 0; k < ratings.length; k++) {
            if (ratings[k] < prev) {
                int size = k - index;
                delta += (sharp <= size ? size : size - 1);
                candy = 1;
            } else {
                candy = ratings[k] > prev ? candy + 1 : 1;
                index = k;
                sharp = candy;
            }
            prev = ratings[k];
            total += candy;
        }
        return total + delta;
    }

    @Test
    public void test0() {
        long prev = -1L + Integer.MIN_VALUE;
        Assert.assertEquals(true, Integer.MIN_VALUE > prev);
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, candy(new int[]{1, 1, 1}));
        Assert.assertEquals(6, candy(new int[]{1, 2, 3}));
        Assert.assertEquals(3, candy(new int[]{1, 2}));
        Assert.assertEquals(7, candy(new int[]{1, 2, 3, 3}));
        Assert.assertEquals(7, candy(new int[]{1, 2, 2, 3, 3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, candy(new int[]{2, 1}));
        Assert.assertEquals(6, candy(new int[]{3, 2, 1}));
        Assert.assertEquals(7, candy(new int[]{3, 3, 2, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, candy(new int[]{1, 8}));
        Assert.assertEquals(4, candy(new int[]{1, 8, 6}));
        Assert.assertEquals(7, candy(new int[]{1, 8, 6, 5}));
        Assert.assertEquals(11, candy(new int[]{1, 8, 6, 5, 3}));
        Assert.assertEquals(16, candy(new int[]{1, 8, 6, 5, 3, 2}));
        Assert.assertEquals(18, candy(new int[]{1, 8, 6, 5, 3, 2, 5}));
        Assert.assertEquals(21, candy(new int[]{1, 8, 6, 5, 3, 2, 5, 7}));
        Assert.assertEquals(22, candy(new int[]{1, 8, 6, 5, 3, 2, 5, 7, 5}));
        Assert.assertEquals(24, candy(new int[]{1, 8, 6, 5, 3, 2, 5, 7, 5, 3}));
        Assert.assertEquals(33, candy(new int[]{1, 8, 6, 5, 3, 2, 5, 7, 5, 3, 2, 1}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, candy(new int[]{1}));
        Assert.assertEquals(1, candy(new int[]{19}));
        Assert.assertEquals(1, candy(new int[]{99}));
        Assert.assertEquals(3, candy(new int[]{99, 88}));
        Assert.assertEquals(2, candy(new int[]{99, 99}));
        Assert.assertEquals(3, candy(new int[]{9, 99}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(4, candy(new int[]{1, 2, 2}));
        Assert.assertEquals(4, candy(new int[]{2, 2, 1}));
    }

    @Test
    public void test6() {
        Assert.assertEquals(9, candy(new int[]{1,2,4,4,3}));
    }
}
