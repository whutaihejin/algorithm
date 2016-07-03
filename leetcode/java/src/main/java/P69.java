import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P69 {

    public int mySqrt(int number) {
        long x = number;
        if (x <= 0) return 0;
        if (x == 1) return 1;
        long low = 0;
        long high = x;
        while (low + 1 < high) {
            long middle = low + (high - low) / 2;
            long product = middle * middle;
            if (product < x) {
                low = middle;
            } else if (product > x) {
                high = middle;
            } else {
                return (int)middle;
            }
        }
        return high * high <= x ? (int)high : (int)low;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, mySqrt(0));
        Assert.assertEquals(1, mySqrt(1));
        Assert.assertEquals(1, mySqrt(2));
        Assert.assertEquals(1, mySqrt(3));
        Assert.assertEquals(2, mySqrt(4));
        Assert.assertEquals(2, mySqrt(8));
        Assert.assertEquals(3, mySqrt(9));
        Assert.assertEquals(3, mySqrt(13));
        Assert.assertEquals(4, mySqrt(16));
        Assert.assertEquals(5, mySqrt(25));
        Assert.assertEquals(5, mySqrt(26));
    }

    @Test
    public void test2() {
        Assert.assertEquals(46339, mySqrt(2147395599));
    }
}
