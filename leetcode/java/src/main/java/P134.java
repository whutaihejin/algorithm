import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-10.
 */
public class P134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int delta = 0, total = 0, index = 0;
        for (int k = 0, left = 0; k < gas.length; k++) {
            left = gas[k] - cost[k];
            delta += left;
            total += left;
            if (delta < 0) {
                delta = 0;
                index = k + 1;
            }
        }
        return total < 0 ? -1 : index;
    }

    @Test
    public void test0() {
        Assert.assertEquals(-1, canCompleteCircuit(new int[]{1, 0}, new int[]{1, 1}));
        Assert.assertEquals(0, canCompleteCircuit(new int[]{2, 0}, new int[]{1, 1}));
        Assert.assertEquals(1, canCompleteCircuit(new int[]{0, 2}, new int[]{1, 1}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, canCompleteCircuit(new int[]{0, 0, 5, 0, 0}, new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(0, canCompleteCircuit(new int[]{5, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(1, canCompleteCircuit(new int[]{0, 5, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(3, canCompleteCircuit(new int[]{0, 0, 0, 5, 0}, new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(4, canCompleteCircuit(new int[]{0, 0, 0, 0, 5}, new int[]{1, 1, 1, 1, 1}));
    }
}
