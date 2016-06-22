package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-20.
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            doQuickSort(nums, low, pivot - 1);
            doQuickSort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int key = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= key) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= key) low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
        return low;
    }

    @Test
    public void test1() {
        int[] nums = {1};
        quickSort(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {2, 1};
        quickSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {1, 2};
        quickSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 7, 6, 5, 4};
        quickSort(nums);
        Assert.assertEquals(4, nums[0]);
        Assert.assertEquals(9, nums[nums.length - 1]);
        Assert.assertEquals(6, nums[2]);
    }
}
