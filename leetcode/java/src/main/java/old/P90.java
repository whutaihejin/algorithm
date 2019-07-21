package old; /**
 * Created by taihejin on 16-7-21.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 0) return ret;
        Arrays.sort(nums);
        ret.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length;) {
            int count = 0;
            int limit = ret.size();
            while (count + i < nums.length && nums[count + i] == nums[i]) count++;
            for (int j = 0; j < limit; j++) {
                List<Integer> item = new ArrayList<Integer>(ret.get(j));
                for (int k = 0; k < count; k++) {
                    item.add(nums[i]);
                    ret.add(new ArrayList<Integer>(item));
                }
            }
            i += count;
        }
        return ret;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, subsetsWithDup(null).size());
        Assert.assertEquals(0, subsetsWithDup(new int[]{}).size());
        Assert.assertEquals(2, subsetsWithDup(new int[]{1}).size());
        Assert.assertEquals(4, subsetsWithDup(new int[]{1, 2}).size());
        Assert.assertEquals(8, subsetsWithDup(new int[]{1, 2, 3}).size());
        Assert.assertEquals(16, subsetsWithDup(new int[]{1, 2, 3, 4}).size());
        Assert.assertEquals(3, subsetsWithDup(new int[]{1, 1}).size());
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, subsetsWithDup(new int[]{1, 2, 2}).size());
    }

    @Test
    public void test2() {
        Assert.assertEquals(10, subsetsWithDup(new int[]{4,4,4,1,4}).size());
        // [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
    }
}
