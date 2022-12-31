package chapter15;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-18.
 */
public class E15_3 {

    public int recursiveDistance(char[] base, int i, char[] target, int j) {
        if (i <= -1) {
            System.out.println(String.format("i %d j %d least %d", i, j, j + 1));
            return j + 1;
        }
        if (j <= -1) {
            System.out.println(String.format("i %d j %d least %d", i, j, i + 1));
            return i + 1;
        }
        if (base[i] == target[j]) {
            int copy = recursiveDistance(base, i - 1, target, j - 1);
            System.out.println(String.format("i %d j %d least %d", i, j, copy));
            return copy;
        }
        int replace = recursiveDistance(base, i - 1, target, j - 1) + 1;
        int least = replace;
        int delete = recursiveDistance(base, i - 1, target, j) + 1;
        least = Math.min(least, delete);
        int insert = recursiveDistance(base, i, target, j - 1) + 1;
        least = Math.min(least, insert);
        if (i >= 1 && j >= 1 && base[i] == target[j - 1] && base[i - 1] == target[j]) {
            int twiddle = recursiveDistance(base, i - 2, target, j - 2) + 1;
            least = Math.min(least, twiddle);
        }
        System.out.println(String.format("i %d j %d least %d", i, j, least));
        return least;
    }

    public int distance(char[] base, char[] target) {
        int row = base.length + 1;
        int column = target.length  + 1;
        int[][] cost = new int[row][column];
        for (int i = 0; i < row; i++) {
            cost[i][0] = i;
        }
        for (int i = 0; i < column; i++) {
            cost[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (base[i - 1] == target[j - 1]) {
                    cost[i][j] = cost[i - 1][j - 1];
                } else {
                    int replace = cost[i - 1][j - 1] + 1;
                    int least = replace;
                    int delete = cost[i - 1][j] + 1;
                    least = Math.min(least, delete);
                    int insert = cost[i][j - 1] + 1;
                    least = Math.min(least, insert);
                    if (i >= 2 && j >= 2 && base[i - 1] == target[j - 2] && base[i - 2] == target[j - 1]) {
                        int twiddle = cost[i - 2][j - 2] + 1;
                        least = Math.min(least, twiddle);
                    }
                    cost[i][j] = least;
                }
            }
        }
        return cost[row - 1][column - 1];
    }

    public int doTest(String base, String target) {
        // return recursiveDistance(base.toCharArray(), base.length() - 1, target.toCharArray(), target.length() - 1);
        return distance(base.toCharArray(), target.toCharArray());
    }

    @Test
    public void test1() {
        String base = "abc";
        String target = "be";
        int distance = doTest(base, target);
        Assert.assertEquals(2, distance);
    }

    @Test
    public void test2() {
        String base = "abc";
        String target = "acb";
        int distance = doTest(base, target);
        Assert.assertEquals(1, distance);
    }

    @Test
    public void test3() {
        String base = "abc";
        String target = "efg";
        int distance = doTest(base, target);
        Assert.assertEquals(3, distance);
    }

}
