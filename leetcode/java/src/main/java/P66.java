import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{1};
        int carry = 1;
        int size = digits.length;
        int[] ret = new int[size + 1];
        for (int i = size - 1; i >=0; i--) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            ret[i + 1] = digits[i];
            carry = val / 10;
        }
        if (carry > 0) {
            ret[0] = carry;
            return  ret;
        } else {
            return digits;
        }
    }

    @Test
    public void test1() {
        int[] ret = plusOne(new int[]{1});
        Assert.assertEquals(2, ret[0]);
    }

    @Test
    public void test2() {
        int[] ret = plusOne(new int[]{2});
        Assert.assertEquals(3, ret[0]);
    }

    @Test
    public void test3() {
        int[] ret = plusOne(new int[]{9});
        Assert.assertEquals(1, ret[0]);
        Assert.assertEquals(0, ret[1]);
    }

    @Test
    public void test4() {
        int[] ret = plusOne(new int[]{9, 9, 9});
        Assert.assertEquals(1, ret[0]);
        Assert.assertEquals(0, ret[1]);
        Assert.assertEquals(0, ret[2]);
        Assert.assertEquals(0, ret[3]);
    }




}
