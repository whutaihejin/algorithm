package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-19.
 */
public class P73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean firstRowSet = false;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) {
                        firstRowSet = true;
                    } else {
                        matrix[r][0] = 0;
                        matrix[0][c] = 0;
                    }
                }
            }
        }
        // set zero for row that below second
        for (int r = 1; r < row; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 0; c < column; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        // set zero for column
        for (int c = 0; c < column; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 0; r < row; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        // for first row
        if (firstRowSet) {
            for (int c = 0; c < column; c++) {
                matrix[0][c] = 0;
            }
        }
    }

    @Test
    public void test0() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 3, 4}
        };
        int[][] setedMatrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 3, 4}
        };
        setZeroes(matrix);
        for (int r = 0; r < matrix.length; r++) {
            Assert.assertArrayEquals(matrix[r], setedMatrix[r]);
        }
    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 0, 3},
                {1, 3, 4}
        };
        int[][] setedMatrix = {
                {1, 0, 3},
                {0, 0, 0},
                {1, 0, 4}
        };
        setZeroes(matrix);
        for (int r = 0; r < matrix.length; r++) {
            Assert.assertArrayEquals(matrix[r], setedMatrix[r]);
        }
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 0, 3},
                {1, 3, 0}
        };
        int[][] setedMatrix = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        setZeroes(matrix);
        for (int r = 0; r < matrix.length; r++) {
            Assert.assertArrayEquals(matrix[r], setedMatrix[r]);
        }
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {0, 2, 3},
                {1, 0, 3},
                {1, 3, 0}
        };
        int[][] setedMatrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        setZeroes(matrix);
        for (int r = 0; r < matrix.length; r++) {
            Assert.assertArrayEquals(matrix[r], setedMatrix[r]);
        }
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}};
        int[][] setedMatrix = {
                {0,0,0,0},
                {0,0,0,4},
                {0,0,0,0},
                {0,0,0,3},
                {0,0,0,0}
        };
        setZeroes(matrix);
        for (int r = 0; r < matrix.length; r++) {
            Assert.assertArrayEquals(matrix[r], setedMatrix[r]);
        }
    }

    @Test
    public void test5() {
        int[][] matrix = {
                {1,1,1},
                {0,1,2}
        };
        int[][] setedMatrix = {
                {0,1,1},
                {0,0,0}
        };
        setZeroes(matrix);
        for (int r = 0; r < matrix.length; r++) {
            Assert.assertArrayEquals(matrix[r], setedMatrix[r]);
        }
    }


}
