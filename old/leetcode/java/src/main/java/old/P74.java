package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-19.
 */
public class P74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0, high = row - 1;
        while (low + 1 < high) {
            int middle = low + (high - low) / 2;
            if (target > matrix[middle][0]) {
                low = middle;
            } else if (target < matrix[middle][0]) {
                high = middle;
            } else {
                return true;
            }
        }
        int index = target >= matrix[high][0] ? high : low;
        low = 0;
        high = column - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (target < matrix[index][middle]) {
                high = middle - 1;
            } else if (target > matrix[index][middle]) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test0() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Assert.assertEquals(true, searchMatrix(matrix, 1));
        Assert.assertEquals(true, searchMatrix(matrix, 3));
        Assert.assertEquals(true, searchMatrix(matrix, 5));
        Assert.assertEquals(true, searchMatrix(matrix, 7));
        Assert.assertEquals(true, searchMatrix(matrix, 10));
        Assert.assertEquals(true, searchMatrix(matrix, 11));
        Assert.assertEquals(true, searchMatrix(matrix, 16));
        Assert.assertEquals(true, searchMatrix(matrix, 20));
        Assert.assertEquals(true, searchMatrix(matrix, 23));
        Assert.assertEquals(true, searchMatrix(matrix, 30));
        Assert.assertEquals(true, searchMatrix(matrix, 34));
        Assert.assertEquals(true, searchMatrix(matrix, 50));
        Assert.assertEquals(false, searchMatrix(matrix, 90));
        Assert.assertEquals(false, searchMatrix(matrix, 18));
        Assert.assertEquals(false, searchMatrix(matrix, 33));
    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 3, 5, 7, 9, 30},
        };
        Assert.assertEquals(true, searchMatrix(matrix, 1));
        Assert.assertEquals(true, searchMatrix(matrix, 3));
        Assert.assertEquals(true, searchMatrix(matrix, 5));
        Assert.assertEquals(true, searchMatrix(matrix, 7));
        Assert.assertEquals(true, searchMatrix(matrix, 9));
        Assert.assertEquals(true, searchMatrix(matrix, 30));
        Assert.assertEquals(false, searchMatrix(matrix, -1));
        Assert.assertEquals(false, searchMatrix(matrix, 20));
        Assert.assertEquals(false, searchMatrix(matrix, 50));
        Assert.assertEquals(false, searchMatrix(matrix, 6));
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1},
                {3},
                {5},
                {7},
                {9},
                {30},
        };
        Assert.assertEquals(true, searchMatrix(matrix, 1));
        Assert.assertEquals(true, searchMatrix(matrix, 3));
        Assert.assertEquals(true, searchMatrix(matrix, 5));
        Assert.assertEquals(true, searchMatrix(matrix, 7));
        Assert.assertEquals(true, searchMatrix(matrix, 9));
        Assert.assertEquals(true, searchMatrix(matrix, 30));
        Assert.assertEquals(false, searchMatrix(matrix, -1));
        Assert.assertEquals(false, searchMatrix(matrix, 20));
        Assert.assertEquals(false, searchMatrix(matrix, 50));
        Assert.assertEquals(false, searchMatrix(matrix, 6));
    }
}
