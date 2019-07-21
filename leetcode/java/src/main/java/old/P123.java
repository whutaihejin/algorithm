package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-13.
 */
public class P123 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length <= 1) {
            return profit;
        }
        int[] diff = new int[prices.length - 1];
        // step 1.
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        // step 2.
        int[] left = new int[diff.length + 1];
        left[0] = 0;
        int[] right = new int[diff.length + 1];
        right[right.length - 1] = 0;
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            profit = Math.max(profit, sum);
            sum = Math.max(0, sum);
            left[i + 1] = profit;
        }
        profit = 0;
        sum = 0;
        for (int i = diff.length - 1; i >= 0; i--) {
            sum += diff[i];
            profit = Math.max(profit, sum);
            sum = Math.max(0, sum);
            right[i] = profit;
        }
        profit = 0;
        for (int i = 0; i < left.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
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

    @Test
    public void test6() {
        int[] prices = {1, 2, 3, -1, 2, 7, -2, 0, 3, -4, 6, 8};
        Assert.assertEquals(20, maxProfit(prices));
    }

    @Test
    public void test7() {
        int[] prices = {6,1,3,2,4,7};
        Assert.assertEquals(7, maxProfit(prices));
    }

    @Test
    public void test8() {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        Assert.assertEquals(13, maxProfit(prices));
    }

    @Test
    public void test9() {
        int[] prices = new int[20000];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = 20000 - i;
        }
        Assert.assertEquals(0, maxProfit(prices));
    }

    @Test
    public void test10() {
        int[] prices = {1, 4, 5, 7, 6, 3, 2, 9};
        maxProfit(prices);
    }

}
