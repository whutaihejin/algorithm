package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-20.
 */

public class P81 {

    private boolean linearSearch(int[] nums, int low, int high, int target) {
        for (; low <= high; low++) {
            if (nums[low] == target) return true;
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (target == nums[middle]) {
                return true;
            } else if (nums[low] < nums[middle]) {
                if (nums[low] <= target && target < nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else if (nums[middle] < nums[high]) {
                if (nums[middle] < target && target <= nums[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                return linearSearch(nums, low, high, target);
            }
        }
        return false;
    }

    @Test
    public void test0() {
        int[] arr = {1, 3, 5, 7};
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, 2));
        Assert.assertEquals(true, search(arr, 3));
        Assert.assertEquals(false, search(arr, 4));
        Assert.assertEquals(true, search(arr, 5));
        Assert.assertEquals(false, search(arr, 6));
        Assert.assertEquals(true, search(arr, 7));
        Assert.assertEquals(false, search(arr, 8));
    }

    @Test
    public void test1() {
        int[] arr = {3, 5, 7, 1};
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, 2));
        Assert.assertEquals(true, search(arr, 3));
        Assert.assertEquals(false, search(arr, 4));
        Assert.assertEquals(true, search(arr, 5));
        Assert.assertEquals(false, search(arr, 6));
        Assert.assertEquals(true, search(arr, 7));
        Assert.assertEquals(false, search(arr, 8));
    }

    @Test
    public void test2() {
        int[] arr = {5, 7, 1, 3};
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, 2));
        Assert.assertEquals(true, search(arr, 3));
        Assert.assertEquals(false, search(arr, 4));
        Assert.assertEquals(true, search(arr, 5));
        Assert.assertEquals(false, search(arr, 6));
        Assert.assertEquals(true, search(arr, 7));
        Assert.assertEquals(false, search(arr, 8));
    }

    @Test
    public void test3() {
        int[] arr = {7, 1, 3, 5};
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, 2));
        Assert.assertEquals(true, search(arr, 3));
        Assert.assertEquals(false, search(arr, 4));
        Assert.assertEquals(true, search(arr, 5));
        Assert.assertEquals(false, search(arr, 6));
        Assert.assertEquals(true, search(arr, 7));
        Assert.assertEquals(false, search(arr, 8));
    }

    @Test
    public void test4() {
        int[] arr = {1};
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, 2));
    }

    @Test
    public void test5() {
        Assert.assertEquals(false, search(null, 1));
        Assert.assertEquals(false, search(new int[]{}, 1));
    }

    @Test
    public void test6() {
        int[] arr = {1, 0, 1, 1, 1, 1, 1};
        Assert.assertEquals(true, search(arr, 0));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(false, search(arr, -20));
        Assert.assertEquals(false, search(arr, 2));
        Assert.assertEquals(false, search(arr, 100));
    }

    @Test
    public void test7() {
        int[] arr = {1, 1, 1, 1, 1, 0, 1};
        Assert.assertEquals(true, search(arr, 0));
        Assert.assertEquals(true, search(arr, 1));
        Assert.assertEquals(false, search(arr, -1));
        Assert.assertEquals(false, search(arr, -15));
        Assert.assertEquals(false, search(arr, 2));
        Assert.assertEquals(false, search(arr, 26));
    }

    @Test
    public void test8() {
        int[] arr = {1, 3};
        Assert.assertEquals(true, search(arr, 1));
    }


}
