package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-22.
 */

public class MergeSort {

    private void merge(int[] nums, int[] backup, int l1, int h1, int l2, int h2) {
        int k = l1;
        int i = l1;
        int j = l2;
        for (; i <= h1 && j <= h2; ) {
            if (nums[i] <= nums[j]) {
                backup[k++] = nums[i++];
            } else {
                backup[k++] = nums[j++];
            }
        }
        for (; i <= h1; ) {
            backup[k++] = nums[i++];
        }
        for (; j <= h2; ) {
            backup[k++] = nums[j++];
        }
        // copy back to nums array
        for (; l1 < k; l1++) {
            nums[l1] = backup[l1];
        }
    }

    private void doMergeSort(int[] nums, int[] backup, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            doMergeSort(nums, backup, low, middle);
            doMergeSort(nums, backup, middle + 1, high);
            merge(nums, backup, low, middle, middle + 1, high);
        }
    }

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int[] backup = new int[nums.length];
        doMergeSort(nums, backup, 0, nums.length - 1);
    }

    @Test
    public void test1() {
        int[] nums = {1};
        mergeSort(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        mergeSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        mergeSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 1, 2, 3, 4, 7, 6, 5};
        mergeSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(5, nums[4]);
        Assert.assertEquals(9, nums[nums.length - 1]);
    }

}
