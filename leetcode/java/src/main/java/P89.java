/**
 * Created by taihejin on 16-7-21.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P89 {

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++) ret.add(i ^ (i >> 1));
        return ret;
    }

    @Test
    public void test0() {
        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << (-1));
        System.out.println(1 << (-2));
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, grayCode(0).size());
        Assert.assertEquals(2, grayCode(1).size());
        Assert.assertEquals(4, grayCode(2).size());
    }

}
