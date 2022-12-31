package old; /**
 * Created by taihejin on 16-7-28.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class P119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return Arrays.asList();
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0, rowIndex + 1, 0);
        Arrays.fill(arr, 0, 1, 1);
        for (int row = 1; row <= rowIndex; row++) {
            for (int high = row; high >= 1; high--) {
                arr[high] += arr[high - 1];
            }
        }
        return Arrays.asList(arr);
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, getRow(-1).isEmpty());
        List<Integer> ret = getRow(0);
        Assert.assertEquals(1, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
    }

    @Test
    public void test1() {
        List<Integer> ret = getRow(1);
        Assert.assertEquals(2, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
        Assert.assertEquals(1, ret.get(1).intValue());
    }

    @Test
    public void test2() {
        List<Integer> ret = getRow(2);
        Assert.assertEquals(3, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
        Assert.assertEquals(2, ret.get(1).intValue());
        Assert.assertEquals(1, ret.get(2).intValue());
    }

    @Test
    public void test3() {
        List<Integer> ret = getRow(3);
        Assert.assertEquals(4, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
        Assert.assertEquals(3, ret.get(1).intValue());
        Assert.assertEquals(3, ret.get(2).intValue());
        Assert.assertEquals(1, ret.get(3).intValue());
    }

    @Test
    public void test4() {
        List<Integer> ret = getRow(6);
        Assert.assertEquals(7, ret.size());
    }
}
