package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-20.
 */
public class BubbleSort {

    public void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    // very smart code, yes they do!
    public void bubbleSort1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int tail = nums.length - 1;
        while (tail != - 1) {
            int bound = tail;
            tail = -1;
            for (int k = 0; k < bound; k++) {
                if (nums[k] > nums[k + 1]) {
                    swap(nums, k, k + 1);
                    tail = k;
                }
            }
        }
    }

    public void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    @Test
    public void test1() {
        int[] nums = {3, 2, 1};
        bubbleSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
        Assert.assertEquals(3, nums[2]);
    }

    @Test
    public void test2() {
        int[] nums = {1};
        bubbleSort(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        bubbleSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {8, 6, 5, 2, 1};
        bubbleSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
        Assert.assertEquals(8, nums[nums.length - 1]);
    }
}
