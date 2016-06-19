import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-18.
 */
public class P53 {

    public int maxSubArray(int[] nums) {
        int profit = 0;
        if (nums == null || nums.length < 1) {
            return profit;
        }
        profit = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            profit = Math.max(profit, sum);
            sum = Math.max(0, sum);
        }
        return profit;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, maxSubArray(null));
        Assert.assertEquals(0, maxSubArray(new int[0]));
        int[] nums = {-1};
        Assert.assertEquals(-1, maxSubArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assert.assertEquals(6, maxSubArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = {3, 4};
        Assert.assertEquals(7, maxSubArray(nums));
        int[] nums1 = {-9, 3, 4};
        Assert.assertEquals(7, maxSubArray(nums1));
    }




}
