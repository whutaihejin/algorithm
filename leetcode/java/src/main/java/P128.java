/**
 * Created by taihejin on 16-8-12.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class P128 {

    public int longestConsecutiveHashSet(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int x = num + 1;
                while (set.contains(x)) {
                    x++;
                }
                longest = Math.max(longest, x - num);
            }
        }
        return longest;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int longest = 0;
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            int repetition = 0;
            while (j < nums.length) {
                if (nums[j] == nums[j - 1]) {
                    repetition++;
                } else if (nums[j] - 1 != nums[j - 1]) {
                    break;
                }
                j++;
            }
            longest = Math.max(longest, j - i - repetition);
            i = j;
        }
        return longest;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, longestConsecutive(new int[]{}));
        Assert.assertEquals(1, longestConsecutive(new int[]{1}));
        Assert.assertEquals(2, longestConsecutive(new int[]{1, 2}));
        Assert.assertEquals(2, longestConsecutive(new int[]{2, 1}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        Assert.assertEquals(5, longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 5}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, longestConsecutive(new int[]{1, 1}));
        Assert.assertEquals(2, longestConsecutive(new int[]{1, 1, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, longestConsecutive(new int[]{1, 2, 0, 1}));
        Assert.assertEquals(3, longestConsecutive(new int[]{1, 2, 0, 0, 0, 1}));
        Assert.assertEquals(4, longestConsecutive(new int[]{1, 2, 0, 0, 0, 1, 3}));
    }
}
