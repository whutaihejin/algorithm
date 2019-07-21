package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-1.
 */
public class P149 {

    private static class Point {
        int x, y;
        Point() { x = 0; y = 0; }

        Point(int a, int b) { x = a; y = b; }

        public String toString() {
            return String.format("(%d %d)", x, y);
        }
    }

    public int maxPoints(Point[] points) {
        if (points.length <= 1) return points.length;
        int size = points.length;
        int amount = 0, repetition = 1;
        for (int i = 0; i < size; i++) {
            int repeat = 1;
            for (int j = i + 1; j < size; j++) {
                if (equal(points[i], points[j])) {
                    repeat++; continue;
                }
                int count = 0;
                for (int k = 0; k < size; k++) {
                    count += (isOnStraightLine(points[i], points[j], points[k]) ? 1 : 0);
                }
                amount = Math.max(amount, count);
            }
            repetition = Math.max(repetition, repeat);
        }
        return Math.max(amount, repetition);
    }

    private boolean equal(Point x, Point y) {
        return x.x == y.x && x.y == y.y;
    }

    private boolean isOnStraightLine(Point x, Point y, Point z) {
        Point vector1 = new Point(y.x - x.x, y.y - x.y);
        Point vector2 = new Point(z.x - x.x, z.y - x.y);
        return (1L * vector1.x * vector2.y == 1L * vector2.x * vector1.y) ? true : false;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, maxPoints(new Point[]{}));
        Assert.assertEquals(1, maxPoints(new Point[]{new Point(0, 0)}));
    }

    @Test
    public void test1() {
        Point[] points = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2)};
        Assert.assertEquals(3, maxPoints(points));
    }

    @Test
    public void test2() {
        Point[] points = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 1)};
        Assert.assertEquals(2, maxPoints(points));
    }

    @Test
    public void test3() {
        // [[-4,-4],[-8,-582],[-3,3],[-9,-651],[9,591]]
        Point[] points = new Point[] {new Point(-4, -4), new Point(-8, -582), new Point(-3, 3), new Point(-9, -651), new Point(9, 591)};
        Assert.assertEquals(3, maxPoints(points));
    }

    @Test
    public void test4() {
        Point[] points = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        Assert.assertEquals(4, maxPoints(points));
    }

    @Test
    public void test5() {
        Point[] points = new Point[]{new Point(-8, -582), new Point(-9, -651), new Point(9, 591)};
        Assert.assertEquals(true, isOnStraightLine(points[0], points[1], points[2]));
    }

    @Test
    public void test6() {
        // [[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
        Point[] points = new Point[]{new Point(84,250),
                new Point(0,0), new Point(1,0), new Point(0,-70),
                new Point(0,-70), new Point(1,-1), new Point(21,10),
                new Point(42,90), new Point(-42,-230)};
        Assert.assertEquals(6, maxPoints(points));
    }

    @Test
    public void test7() {
        Point[] points = new Point[]{new Point(0, 0), new Point(0, 0)};
        Assert.assertEquals(2, maxPoints(points));
    }

    @Test
    public void test8() {
        Point[] points = new Point[]{new Point(0, 0), new Point(0, 0),
                new Point(0, 0), new Point(1, 1), new Point(1, 1), new Point(2, 2)};
        Assert.assertEquals(6, maxPoints(points));
    }
}
