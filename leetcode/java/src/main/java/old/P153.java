package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhanglonghanks on 16/9/23.
 */
public class P153 {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int middle = low + (high - low) / 2;
            if (nums[low] < nums[middle]) {
                if (nums[middle] < nums[high]) {
                    high = middle;
                } else {
                    low = middle;
                }
            } else {
                if (nums[middle] < nums[high]) {
                    high = middle;
                } else {
                    low = middle;
                }
            }
        }
        return nums[low] < nums[high] ? nums[low] : nums[high];
    }

    @Test
    public void test0() {
        Assert.assertEquals(-1, findMin(new int[]{-1}));
        Assert.assertEquals(0, findMin(new int[]{0}));
        Assert.assertEquals(1, findMin(new int[]{1}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, findMin(new int[]{0, 1}));
        Assert.assertEquals(0, findMin(new int[]{1, 0}));
        Assert.assertEquals(0, findMin(new int[]{3, 0}));
        Assert.assertEquals(-1, findMin(new int[]{-1, 0}));
        Assert.assertEquals(-1, findMin(new int[]{-1, 3}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, findMin(new int[]{0, 1, 2}));
        Assert.assertEquals(0, findMin(new int[]{1, 2, 0}));
        Assert.assertEquals(0, findMin(new int[]{2, 0, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(0, findMin(new int[]{6, 7, 0, 1, 2, 4, 5}));
        Assert.assertEquals(0, findMin(new int[]{7, 0, 1, 2, 4, 5, 6}));
        Assert.assertEquals(0, findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        Assert.assertEquals(0, findMin(new int[]{1, 2, 4, 5, 6, 7, 0}));
        Assert.assertEquals(0, findMin(new int[]{2, 4, 5, 6, 7, 0, 1}));
        Assert.assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
