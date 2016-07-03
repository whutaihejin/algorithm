import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P70 {

    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int low = 1;
        int high = 1;
        for (int i = 2; i <= n; i++) {
            int val = low + high;
            low = high;
            high = val;
        }
        return high;
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, climbStairs(0));
        Assert.assertEquals(1, climbStairs(1));
        Assert.assertEquals(2, climbStairs(2));
        Assert.assertEquals(3, climbStairs(3));
    }
}
