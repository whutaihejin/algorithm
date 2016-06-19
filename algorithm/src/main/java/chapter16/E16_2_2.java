package chapter16;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-19.
 */
public class E16_2_2 {
    public int maxValue(int[] values, int[] weights, int W) {
        int row = values.length + 1;
        int column = W + 1;
        int[][] matrix = new int[row][column];
        for (int c = 0; c < column; c++) {
            matrix[0][c] = 0;
        }
        for (int r = 0; r < row; r++) {
            matrix[r][0] = 0;
        }
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < column; c++) {
                int value = 0;
                if (c >= weights[r - 1]) {
                    value = matrix[r - 1][c - weights[r - 1]] + values[r - 1];
                }
                matrix[r][c] = Math.max(value, matrix[r - 1][c]);
            }
        }
        return matrix[row - 1][column - 1];
    }

    @Test
    public void test1() {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        Assert.assertEquals(220, maxValue(values, weights, 50));
    }
}
