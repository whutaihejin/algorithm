package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-17.
 */
public class P96 {

    public int numTrees(int n) {
        int ret = 1;
        if (n <= 1) {
            return ret;
        }
        int[] arrow = new int[n + 1];
        arrow[0] = 1;
        arrow[1] = 1;
        for (int i = 2; i <= n; i++) {
            int mount = 0;
            for (int k = 1; k <= i; k++) {
                mount += arrow[k - 1] * arrow[i - k];
            }
            arrow[i] = mount;
        }
        return arrow[n];
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, numTrees(0));
        Assert.assertEquals(1, numTrees(1));
        Assert.assertEquals(2, numTrees(2));
        Assert.assertEquals(5, numTrees(3));
    }

    @Test
    public void test2() {
        numTrees(1000);
    }

}
