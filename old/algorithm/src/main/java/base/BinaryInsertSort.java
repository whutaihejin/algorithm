package base;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-20.
 */
public class BinaryInsertSort {

    public void binaryInsertSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                if (nums[middle] > value) {
                    high = middle - 1;
                } else if (nums[middle] < value) {
                    low = middle + 1;
                } else {
                    break;
                }
            }
            for (int j = i - 1; j >= high + 1; j--) {
                nums[j + 1] = nums[j];
            }
            nums[high + 1] = value;
        }
    }

    @Test
    public void test1() {
        int[] nums = {1};
        binaryInsertSort(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        binaryInsertSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        binaryInsertSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {6, 5, 4, 3, 2, 1};
        binaryInsertSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(4, nums[3]);
        Assert.assertEquals(6, nums[nums.length - 1]);
    }
}
