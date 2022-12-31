package old;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by taihejin on 16-8-18.
 */
public class P152 {

    public int maxProduct(int[] nums) {
        int product = nums[0];
        int max = product, min = product;
        for (int i = 1; i < nums.length; i++) {
            int left = max * nums[i];
            int right = min * nums[i];
            max = Math.max(left, Math.max(nums[i], right));
            min = Math.min(left, Math.min(nums[i], right));
            product = Math.max(product, max);
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
        Assert.assertEquals(16, maxProduct(new int[]{2, 3, -2, 0, 4, 4}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, maxProduct(new int[]{0, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(12, maxProduct(new int[]{-4, -3, -2}));
    }

}
