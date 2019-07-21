package old; /**
 * Created by taihejin on 16-8-11.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = triangle.get(triangle.size() - 1);
        Integer[] arr = new Integer[last.size()];
        last.toArray(arr);
        for (int k = triangle.size() - 2; k >= 0; k--) {
            List<Integer> row = triangle.get(k);
            for (int i = 0; i < row.size(); i++) {
                arr[i] = row.get(i) + Math.min(arr[i], arr[i + 1]);
            }
        }
        return arr[0];
    }

    @Test
    public void test0() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        Assert.assertEquals("[1, 2, 3, 4]", Arrays.toString(arr));
    }

    @Test
    public void test1() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Assert.assertEquals(11, minimumTotal(triangle));
    }

    @Test
    public void test2() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(5));
        Assert.assertEquals(5, minimumTotal(triangle));
    }

    @Test
    public void test3() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(2, 3));
        Assert.assertEquals(3, minimumTotal(triangle));
    }

}
