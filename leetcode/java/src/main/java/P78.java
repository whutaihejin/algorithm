/**
 * Created by taihejin on 16-7-20.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class P78 {

    public void doSubsets(int[] nums, int i, List<Integer> tmp, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            System.out.println(Arrays.toString(tmp.toArray()));
            return;
        }
        doSubsets(nums, i + 1, tmp, result);
        tmp.add(nums[i]);
        int index = tmp.size() - 1;
        doSubsets(nums, i + 1, tmp, result);
        tmp.remove(index);
    }

    public List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        doSubsets(nums, 0, tmp, result);
        return result;
    }

    public List<List<Integer>> subsetsIterator1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 0) return ret;
        Arrays.sort(nums);
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> item = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 0x01) == 1) {
                    item.add(nums[j]);
                }
            }
            ret.add(item);
        }
        return ret;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 0) return ret;
        ret.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int limit = ret.size();
            for (int k = 0; k < limit; k++) {
                List<Integer> item = new ArrayList<Integer>(ret.get(k));
                item.add(nums[i]);
                ret.add(item);
                System.out.println(Arrays.toString(item.toArray()));
            }
        }
        return ret;
    }

    @Test
    public void test0() {
        List<List<Integer>> result = subsets(null);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void test1() {
        List<List<Integer>> result = subsets(new int[]{});
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void test2() {
        List<List<Integer>> result = subsets(new int[]{1});
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void test3() {
        List<List<Integer>> result = subsets(new int[]{1, 2});
        Assert.assertEquals(4, result.size());
    }

    @Test
    public void test4() {
        List<List<Integer>> result = subsets(new int[]{1, 2, 3});
        Assert.assertEquals(8, result.size());
    }
}
