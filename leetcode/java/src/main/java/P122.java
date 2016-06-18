import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-13.
 */
public class P122 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length <= 1) {
            return profit;
        }
        // step 1. adjacent diff
        int[] diff = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        // step 2. max profix
        for (int i = 0; i < diff.length; i++) {
            profit += (diff[i] > 0 ? diff[i] : 0);
        }
        return profit;
    }

    @Test
    public void test1() {
        int[] prices = {};
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = {1};
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test3() {
        int[] prices = {1, 2};
        Assert.assertEquals(1, maxProfit(prices));
    }

    @Test
    public void test4() {
        int[] prices = {2, 1};
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test5() {
        int[] prices = {3, 4, 5, 4, 3, 4, 5};
        Assert.assertEquals(4, maxProfit(prices));
    }
}
