package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-11.
 */
public class P115 {

    public int numDistinct(String s, String t) {
        int row = s.length() + 1;
        int column = t.length() + 1;
        int[][] matrix = new int[row][column];
        for (int c = 0; c < column; c++) {
            matrix[0][c] = 0;
        }
        for (int r = 0; r < row; r++) {
            matrix[r][0] = 1;
        }
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < column; c++) {
                if (t.charAt(c - 1) == s.charAt(r - 1)) {
                    matrix[r][c] = matrix[r - 1][c] + matrix[r - 1][c - 1];
                } else {
                    matrix[r][c] = matrix[r - 1][c];
                }
            }
        }
        return matrix[row - 1][column - 1];
    }

    @Test
    public void test0() {
        Assert.assertEquals(1, numDistinct("", ""));
        Assert.assertEquals(0, numDistinct("", "s"));
        Assert.assertEquals(0, numDistinct("", "ss"));
        Assert.assertEquals(1, numDistinct("s", ""));
        Assert.assertEquals(1, numDistinct("ss", ""));
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, numDistinct("a", "a"));
        Assert.assertEquals(0, numDistinct("a", "aa"));
        Assert.assertEquals(1, numDistinct("aa", "aa"));
        Assert.assertEquals(2, numDistinct("aa", "a"));
        Assert.assertEquals(2, numDistinct("nstt", "st"));
        Assert.assertEquals(2, numDistinct("nstt", "t"));
        Assert.assertEquals(2, numDistinct("nstt", "nst"));
        Assert.assertEquals(1, numDistinct("nstt", "nstt"));
    }
}
