package old;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by taihejin on 16-7-19.
 */
public class P75 {

    public void swap(int[] nums, int low, int high) {
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int low = 0;
        int high = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < high){
                swap(nums, i, high--);
            }
            while (nums[i] == 0 && i > low) {
                swap(nums, i, low++);
            }
        }
    }

    @Test
    public void test0() {
        int[] nums = {2, 2, 1, 1, 0, 0};
        sortColors(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void test1() {
        int[] nums = {2, 1, 1, 0, 0};
        sortColors(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2}, nums);
    }

    @Test
    public void test2() {
        int[] nums = {2, 1, 1, 0};
        sortColors(nums);
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2}, nums);
    }

    @Test
    public void test3() {
        int[] nums = {2, 2, 0, 0};
        sortColors(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 2, 2}, nums);
    }
}


