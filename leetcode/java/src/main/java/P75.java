import org.junit.Assert;
import org.junit.Test;


/**
 * Created by taihejin on 16-7-19.
 */
public class P75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0: redCount++; break;
                case 1: whiteCount++; break;
                case 2: blueCount++; break;
            }
        }
        int k = 0;
        for (int i = 0; i < redCount; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < whiteCount; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < blueCount; i++) {
            nums[k++] = 2;
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
}


