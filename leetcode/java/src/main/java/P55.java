import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-18.
 */
public class P55 {

    public boolean canJump(int[] nums) {
        int last = 0;
        int cur = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i > last) {
                last = cur;
            }
            cur = Math.max(cur, i + nums[i]);
            if (cur == i || last >= size - 1) {
                break;
            }
        }
        return last >= size - 1 ? true : false;
    }

    @Test
    public void test1() {
        int[] nums = {1, 0, 1, 1};
        Assert.assertEquals(false, canJump(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2,3,1,1,4};
        Assert.assertEquals(true, canJump(nums));
    }

    @Test
    public void test3() {
        int[] nums = {3,2,1,0,4};
        Assert.assertEquals(false, canJump(nums));
    }

    @Test
    public void test4() {
        int[] nums = {0,3,2,1,0,4};
        Assert.assertEquals(false, canJump(nums));
    }

    @Test
    public void test5() {
        int[] nums = {2, 3, 1, 1, 1, 1, 1, 1, 1, 0, 4};
        Assert.assertEquals(false, canJump(nums));
    }

    @Test
    public void test6() {
        int[] nums = {2, 9, 1, 1, 1, 1, 1, 1, 1, 0, 4};
        Assert.assertEquals(true, canJump(nums));
    }

}
