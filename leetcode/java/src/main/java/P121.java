import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-13.
 */
public class P121 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // step 1. adjacent diff
        int[] diff = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        // step 2. max sub array sum
        int sum = 0;
        int profix = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            profix = Math.max(profix, sum);
            sum = Math.max(0, sum);
        }
        return profix;
    }

    @Test
    public void test0() {
        int[] prices = {};
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test1() {
        int[] prices = {1};
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        Assert.assertEquals(4, maxProfit(prices));
    }

    @Test
    public void test3() {
        int[] prices = {1, 2};
        Assert.assertEquals(1, maxProfit(prices));
    }

    @Test
    public void test4() {
        int[] prices = {3, 2, 0};
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test5() {
        int[] prices = {2, 1};
        Assert.assertEquals(0, maxProfit(prices));
    }

}
