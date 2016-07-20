import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-20.
 */
public class P80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length;) {
            int j = i;
            for (; j < nums.length && nums[j] == nums[i]; j++) {
                if (j - i <= 1) {
                    nums[k++] = nums[j];
                }
            }
            i = j;
        }
        return k;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, removeDuplicates(null));
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
        Assert.assertEquals(1, removeDuplicates(new int[]{1}));
        Assert.assertEquals(2, removeDuplicates(new int[]{1, 1}));
        Assert.assertEquals(2, removeDuplicates(new int[]{1, 1, 1}));
        Assert.assertEquals(2, removeDuplicates(new int[]{1, 1, 1, 1}));
        Assert.assertEquals(3, removeDuplicates(new int[]{1, 1, 1, 1, 2}));
        Assert.assertEquals(4, removeDuplicates(new int[]{1, 1, 1, 1, 2, 2}));
        Assert.assertEquals(4, removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1,1,1,2,2,3}));
        Assert.assertEquals(4, removeDuplicates(new int[]{1, 2, 3, 4}));
    }
}
