package old;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by taihejin on 16-6-17.
 */
public class P88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int p = m - 1;
        int q = n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] >= nums2[q]) {
                nums1[k--] = nums1[p--];
            } else {
                nums1[k--] = nums2[q--];
            }
        }
        while (q >= 0) {
            nums1[k--] = nums2[q--];
        }
    }

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {7, 8, 9};
        merge(nums1, 3, nums2, 3);
        Assert.assertEquals(1, nums1[0]);
        Assert.assertEquals(9, nums1[5]);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        merge(nums1, 3, nums2, 3);
        Assert.assertEquals(1, nums1[0]);
        Assert.assertEquals(6, nums1[5]);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test3() {
        int[] nums1 = {1, 8, 11, 0, 0, 0};
        int[] nums2 = {5, 6, 7};
        merge(nums1, 3, nums2, 3);
        Assert.assertEquals(1, nums1[0]);
        Assert.assertEquals(11, nums1[5]);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test4() {
        int[] nums1 = {1, 8, 11, 0, 0, 0};
        int[] nums2 = {5, 6, 7};
        merge(nums1, 0, nums2, 3);
        Assert.assertEquals(5, nums1[0]);
        Assert.assertEquals(7, nums1[2]);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test5() {
        int[] nums1 = {1, 8, 11, 0, 0, 0};
        int[] nums2 = {5, 6, 7};
        merge(nums1, 3, nums2, 0);
        Assert.assertEquals(1, nums1[0]);
        Assert.assertEquals(11, nums1[2]);
        System.out.println(Arrays.toString(nums1));
    }
}
