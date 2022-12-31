package old; /**
 * Created by taihejin on 16-7-28.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows <= 0) return ret;
        ret.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> level = ret.get(i - 1);
            List<Integer> item = new ArrayList<Integer>();
            item.add(1);
            for (int k = 1; k < i; k++) {
                item.add(level.get(k) + level.get(k - 1));
            }
            item.add(1);
            ret.add(item);
        }
        return ret;
    }

    @Test
    public void test0() {
        List<List<Integer>> ret = generate(0);
        Assert.assertEquals(true, ret.isEmpty());
    }

    @Test
    public void test1() {
        List<List<Integer>> ret = generate(1);
        Assert.assertEquals(1, ret.size());
    }

    @Test
    public void test2() {
        List<List<Integer>> ret = generate(2);
        Assert.assertEquals(2, ret.size());
    }

    @Test
    public void test3() {
        List<List<Integer>> ret = generate(5);
        Assert.assertEquals(5, ret.size());
    }

    @Test
    public void test4() {
        List<List<Integer>> ret = generate(10);
        Assert.assertEquals(10, ret.size());
    }
}
