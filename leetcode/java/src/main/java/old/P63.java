package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m <= 0 || n <= 0 || obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for (int row = 1; row < m; row++) {
            if (obstacleGrid[row][0] == 1) {
                obstacleGrid[row][0] = 0;
            } else {
                obstacleGrid[row][0] = obstacleGrid[row - 1][0];
            }
        }
        for (int column = 1; column < n; column++) {
            if (obstacleGrid[0][column] == 1) {
                obstacleGrid[0][column] = 0;
            } else {
                obstacleGrid[0][column] = obstacleGrid[0][column - 1];
            }
        }
        for (int row = 1; row < m ; row++) {
            for (int column = 1; column < n; column++) {
                if (obstacleGrid[row][column] == 1) {
                    obstacleGrid[row][column] = 0;
                } else {
                    obstacleGrid[row][column] = obstacleGrid[row - 1][column] + obstacleGrid[row][column - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    @Test
    public void test1() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Assert.assertEquals(2, uniquePathsWithObstacles(grid));
    }

}
