/**
 * Created by taihejin on 16-7-19.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P77 {

    public void doCombine(List<Integer> list, List<List<Integer>> result, int cur, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (n - cur + 1 < k) return;
        list.add(cur);
        int index = list.size() - 1;
        doCombine(list, result, cur + 1, n, k - 1);
        list.remove(index);
        doCombine(list, result, cur + 1, n, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) return result;
        List<Integer> tmp = new ArrayList<Integer>();
        doCombine(tmp, result, 1, n, k);
        return result;
    }

    @Test
    public void test0() {
        List<List<Integer>> result = combine(4, 2);
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void test1() {
        List<List<Integer>> result = combine(4, 1);
        Assert.assertEquals(4, result.size());
    }

    @Test
    public void test2() {
        List<List<Integer>> result = combine(4, 3);
        Assert.assertEquals(4, result.size());
    }

    @Test
    public void test3() {
        List<List<Integer>> result = combine(4, 4);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void test4() {
        List<List<Integer>> result = combine(5, 3);
        Assert.assertEquals(10, result.size());
    }
}
