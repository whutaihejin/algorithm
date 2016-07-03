import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by taihejin on 16-6-19.
 */
public class P60 {

    /* Problem description:
    The set [1,2,3,…,n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order,
    We get the following sequence (ie, for n = 3):
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.*/

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            count *= (i + 1);
        }
        k--;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            count /= (n - i);
            int selected = k / count;
            k %= count;
            builder.append(nums[selected]);
            for (int j = selected + 1; j < n; j++) {
                nums[j - 1] = nums[j];
            }
        }
        return builder.toString();
    }

    public void next(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = nums.length - 1;
        int tail = index;
        for (; index >= 1; index--) {
            if (nums[index - 1] < nums[index]) {
                break;
            }
        }
        // reverse fully
        if (index == 0) {
            Arrays.sort(nums);
            return;
        }
        for (; tail >= index; tail--) {
            if (nums[tail] > nums[index - 1]) {
                break;
            }
        }
        // exchange
        int temp = nums[index - 1];
        nums[index - 1] = nums[tail];
        nums[tail] = temp;
        // reverse
        int low = index;
        int high = nums.length - 1;
        while (low < high) {
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public String doGetPermutation(int n, int k) {
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        long product = 1;
        for (long i = 1; i <= n; i++) {
            product *= i;
        }
        if (k > product) {
            k %= product;
        }
        for (int i = 1; i < k; i++) {
            next(nums);
        }
        StringBuilder builder = new StringBuilder();
        for (int value : nums) {
            builder.append(String.valueOf(value));
        }
        return builder.toString();
    }

    @Test
    public void test1() {
        int[] nums = {1};
        next(nums);
        Assert.assertEquals(1, nums[0]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        next(nums);
        Assert.assertEquals("[2, 1]", Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {2, 1};
        next(nums);
        Assert.assertEquals("[1, 2]", Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = {1, 2, 3};
        next(nums);
        Assert.assertEquals("[1, 3, 2]", Arrays.toString(nums));
    }

    @Test
    public void test5() {
        int[] nums = {3, 2, 1};
        next(nums);
        Assert.assertEquals("[1, 2, 3]", Arrays.toString(nums));
    }

    @Test
    public void test6() {
        int[] nums = {4, 7, 5, 3, 2};
        next(nums);
        Assert.assertEquals("[5, 2, 3, 4, 7]", Arrays.toString(nums));
    }

    @Test
    public void test7() {
        Assert.assertEquals("123", getPermutation(3, 1));
        Assert.assertEquals("132", getPermutation(3, 2));
        Assert.assertEquals("213", getPermutation(3, 3));
        Assert.assertEquals("231", getPermutation(3, 4));
        Assert.assertEquals("312", getPermutation(3, 5));
        Assert.assertEquals("321", getPermutation(3, 6));
    }

    @Test
    public void test8() {
        Assert.assertEquals("", getPermutation(0, 0));
        Assert.assertEquals("1", getPermutation(1, 1));
    }

    @Test
    public void test9() {
        getPermutation(8, 8590);
    }

    @Test
    public void test10() {
        Assert.assertEquals("12", getPermutation(2, 1));
        Assert.assertEquals("21", getPermutation(2, 2));
    }





}
