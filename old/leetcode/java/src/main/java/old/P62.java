package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P62 {

    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        int[][] matrix = new int[m][n];
        for (int row = 0; row < m; row++) {
            matrix[row][0] = 1;
        }
        for (int column = 0; column < n; column++) {
            matrix[0][column] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                matrix[row][column] = matrix[row][column - 1] + matrix[row - 1][column];
            }
        }
        return matrix[m - 1][n - 1];
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, uniquePaths(1, 1));
        Assert.assertEquals(2, uniquePaths(2, 2));
        Assert.assertEquals(3, uniquePaths(2, 3));
        Assert.assertEquals(6, uniquePaths(3, 3));
    }
}
