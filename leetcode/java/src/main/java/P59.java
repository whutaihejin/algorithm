import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-6-19.
 */
public class P59 {

    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int count = 1;
        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                matrix[top][c] = count++;
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                matrix[r][right] = count++;
            }
            right--;
            for (int c = right; c >= left && top <= bottom; c--) {
                matrix[bottom][c] = count++;
            }
            bottom--;
            for (int r = bottom; r >= top && left <= right; r--) {
                matrix[r][left] = count++;
            }
            left++;
        }
        return matrix;
    }

    @Test
    public void test1() {
        int[][] matrix = generateMatrix(1);
        Assert.assertEquals(1, matrix[0][0]);
    }

    @Test
    public void test2() {
        int[][] matrix = generateMatrix(2);
        Assert.assertEquals(1, matrix[0][0]);
        Assert.assertEquals(2, matrix[0][1]);
        Assert.assertEquals(4, matrix[1][0]);
        Assert.assertEquals(3, matrix[1][1]);
    }

    @Test
    public void test3() {
        int[][] matrix = generateMatrix(3);
        Assert.assertEquals(1, matrix[0][0]);
        Assert.assertEquals(2, matrix[0][1]);
        Assert.assertEquals(3, matrix[0][2]);
        Assert.assertEquals(8, matrix[1][0]);
        Assert.assertEquals(9, matrix[1][1]);
        Assert.assertEquals(4, matrix[1][2]);
        Assert.assertEquals(7, matrix[2][0]);
        Assert.assertEquals(6, matrix[2][1]);
        Assert.assertEquals(5, matrix[2][2]);
    }
}
