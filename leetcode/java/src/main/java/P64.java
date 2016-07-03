import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P64 {

    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = m >= 1 ? grid[0].length : 0;
        if (m <= 0 || n <= 0) return 0;
        for (int row = 1; row < m; row++) {
            grid[row][0] += grid[row - 1][0];
        }
        for (int column = 1; column < n; column++) {
            grid[0][column] += grid[0][column - 1];
        }
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                grid[row][column] += Math.min(grid[row - 1][column], grid[row][column - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, minPathSum(new int[0][0]));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, minPathSum(new int[][]{{1}}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, minPathSum(new int[][]{{1, 1}, {2, 1}}));
    }

}
