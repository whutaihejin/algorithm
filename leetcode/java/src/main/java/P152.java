import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;

/**
 * Created by taihejin on 16-8-18.
 */
public class P152 {

    // Time Limit Exceeded
    public int maxProduct(int[] nums) {
        int product = Integer.MIN_VALUE;
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                int current = 1;
                for (int k = i; k <= j; k++) {
                    current *= nums[k];
                }
                product = Math.max(product, current);
            }
        }
        return product;
    }

    @Test
    public void test0() {
        Assert.assertEquals(-2, maxProduct(new int[]{-2}));
        Assert.assertEquals(-1, maxProduct(new int[]{-1}));
        Assert.assertEquals(0, maxProduct(new int[]{0}));
        Assert.assertEquals(1, maxProduct(new int[]{1}));
        Assert.assertEquals(2, maxProduct(new int[]{2}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, maxProduct(new int[]{0, 2}));
    }

}
