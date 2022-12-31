package old;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by taihejin on 16-6-19.
 */
public class P57 {

    public static class Interval {

        private int start;
        private int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append('[').append(start).append(',')
                    .append(' ').append(end).append(']');
            return builder.toString();
        }
    }

    public static class Comparetor<T extends Interval> implements Comparator<T> {

        public int compare(T x, T y) {
            int ret = 0;
            if (x == null) {
                ret = y == null ? 0 : -1;
            }
            if (y == null) {
                ret = 1;
            }
            if (x instanceof Interval && y instanceof Interval) {
                if (((Interval) x).end > ((Interval) y).end) {
                    ret = 1;
                } else if (((Interval) x).end == ((Interval) y).end) {
                    ret = 0;
                } else {
                    ret = -1;
                }
            }
            return ret;
        }

    }

    private void shrink(List<Interval> list) {
        int size = 0;
        while ((size = list.size()) >= 2) {
            Interval last = list.get(size - 1);
            Interval pre = list.get(size - 2);
            if (last.start > pre.end) {
                break;
            }
            int start = pre.start <= last.start ? pre.start : last.start;
            pre.start = start;
            pre.end = last.end;
            list.remove(size - 1);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>();
        if (intervals == null) {
            return list;
        }
        intervals.add(newInterval);
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparetor<Interval>());
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval val = intervals.get(i);
            Interval cur = list.get(list.size() - 1);
            if (val.start <= cur.end) {
                int start = cur.start < val.start ? cur.start : val.start;
                cur.start = start;
                cur.end = val.end;
                shrink(list);
            } else {
                list.add(val);
            }
        }
        return list;
    }

    @Test
    public void test1() {
        Comparator<Interval> comparator = new Comparetor<Interval>();
        Interval x = new Interval(0, 2);
        Interval y = new Interval(0, 4);
        Assert.assertEquals(-1, comparator.compare(x, y));
    }

    @Test
    public void test2() {
        Comparator<Interval> comparator = new Comparetor<Interval>();
        Interval x = new Interval(0, 4);
        Interval y = new Interval(0, 4);
        Assert.assertEquals(0, comparator.compare(x, y));
    }

    @Test
    public void test3() {
        Comparator<Interval> comparator = new Comparetor<Interval>();
        Interval x = new Interval(0, 6);
        Interval y = new Interval(0, 4);
        Assert.assertEquals(1, comparator.compare(x, y));
    }

    @Test
    public void test4() {
        List<Interval> list = new ArrayList<Interval>();
        Interval x = new Interval(0, 2);
        list.add(x);
        Interval val = list.get(0);
        val.start = 2;
        val.end = 5;
        Interval y = list.get(0);
        Assert.assertEquals(2, y.start);
        Assert.assertEquals(5, y.end);
    }

    @Test
    public void test5() {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(1, 10));
        shrink(list);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void test6() {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 9));
        List<Interval> result = insert(list, new Interval(1, 10));
        System.out.println(Arrays.toString(result.toArray()));
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void test7() {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));
        List<Interval> result = insert(list, new Interval(2, 5));
        System.out.println(Arrays.toString(result.toArray()));
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void test8() {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));
        List<Interval> result = insert(list, new Interval(4, 9));
        System.out.println(Arrays.toString(result.toArray()));
        Assert.assertEquals(3, result.size());
    }
}
