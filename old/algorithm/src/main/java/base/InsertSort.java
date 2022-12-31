package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-20.
 */
public class InsertSort {

    public void insertSortNormal(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > value; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = value;
        }
    }

    public void insertSortWithSentinel(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return;
        }
        for (int i = 2; i < nums.length; i++) {
            nums[0] = nums[i];
            int j = i - 1;
            for (; nums[j] > nums[0]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = nums[0];
        }
    }

    @Test
    public void test1() {
        int[] nums = {1};
        insertSortNormal(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {2, 1};
        insertSortNormal(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {1, 2};
        insertSortNormal(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertSortNormal(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(9, nums[nums.length - 1]);
    }

    @Test
    public void test5() {
        int[] nums = {0, 1};
        insertSortWithSentinel(nums);
        Assert.assertEquals(1, nums[1]);
    }

    @Test
    public void test6() {
        int[] nums = {0, 2, 1};
        insertSortWithSentinel(nums);
        Assert.assertEquals(1, nums[1]);
        Assert.assertEquals(2, nums[2]);
    }

    @Test
    public void test7() {
        int[] nums = {0, 1, 2};
        insertSortWithSentinel(nums);
        Assert.assertEquals(1, nums[1]);
        Assert.assertEquals(2, nums[2]);
    }

    @Test
    public void test8() {
        int[] nums = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertSortWithSentinel(nums);
        Assert.assertEquals(1, nums[1]);
        Assert.assertEquals(9, nums[nums.length - 1]);
    }
}
