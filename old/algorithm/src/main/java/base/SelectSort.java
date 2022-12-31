package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-22.
 */
public class SelectSort {

    public void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(nums, i, minIndex);
            }
        }
    }

    @Test
    public void test1() {
        int[] nums = {1};
        selectSort(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        selectSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        selectSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 7, 6, 5, 3, 2, 1};
        selectSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(5, nums[3]);
        Assert.assertEquals(9, nums[nums.length - 1]);
    }
}
