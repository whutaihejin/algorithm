package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-20.
 */
public class ShellSort {

    public void shellSort(int[] nums, int[] deltas) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (deltas == null || deltas.length < 1) {
            deltas = new int[] {1};
        }
        for (int k = 0; k < deltas.length; k++) {
            doShellSort(nums, deltas[k]);
        }
    }

    public void doShellSort(int[] nums, int delta) {
        for (int i = delta; i < nums.length; i++) {
            int value = nums[i];
            int j = i - delta;
            for (; j >= 0 && nums[j] > value; j -= delta) {
                nums[j + delta] = nums[j];
            }
            nums[j + delta] = value;
        }
    }

    @Test
    public void test1() {
        int[] nums = {1};
        int[] deltas = {5, 3, 1};
        shellSort(nums, deltas);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        int[] deltas = {5, 3, 1};
        shellSort(nums, deltas);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        int[] deltas = {5, 3, 1};
        shellSort(nums, deltas);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] deltas = {5, 3, 1};
        shellSort(nums, deltas);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(4, nums[3]);
        Assert.assertEquals(9, nums[nums.length - 1]);
    }


}
