package base;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-22.
 */
public class HeapSort {

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public void heapify(int[] nums, int i, int size) {
        while (i < size) {
            int largest = i;
            int left = (i << 1) + 1;
            int right = left + 1;
            if (left < size && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right < size && nums[right] > nums[largest]) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(nums, i, largest);
            i = largest;
        }
    }

    public void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
    }

    public void heapSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        buildHeap(nums);
        for (int index = nums.length - 1; index > 0; index--) {
            swap(nums, 0, index);
            heapify(nums, 0, index);
        }
    }

    @Test
    public void test1() {
        int[] nums = {1};
        heapSort(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        heapSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        heapSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 1, 2, 3, 7, 6, 5, 4};
        heapSort(nums);
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(5, nums[4]);
        Assert.assertEquals(9, nums[8]);
    }

}
