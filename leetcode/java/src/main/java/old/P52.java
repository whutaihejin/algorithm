package old; /**
 * Created by taihejin on 16-6-18.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P52 {

    private static final char QUEEN_CHAR = 'Q';
    private static final char EMPTY_CHAR = '.';

    private boolean isValid(char[][] board, int row, int column) {
        int size = board.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == QUEEN_CHAR) {
                    if (j == column || Math.abs(i - row) == Math.abs(j - column)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void doSolve(char[][] board, int row, int[] result) {
        int size = board.length;
        if (row == size) {
            result[0]++;
            return;
        }
        for (int i = 0; i < size; i++) {
            board[row][i] = QUEEN_CHAR;
            if (isValid(board, row, i)) {
                doSolve(board, row + 1, result);
            }
            board[row][i] = EMPTY_CHAR;
        }
    }

    public int totalNQueens(int n) {
        int[] result = {0};
        if (n < 1) {
            return result[0];
        }
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                board[row][column] = EMPTY_CHAR;
            }
        }
        doSolve(board, 0, result);
        return result[0];
    }

    @Test
    public void test1() {
        char[][] board = {
                {'.', '.'},
                {'.', '.'}
        };
        Assert.assertEquals(true, isValid(board, 0, 0));
    }

    @Test
    public void test2() {
        char[][] board = {
                {'Q', '.'},
                {'.', '.'}
        };
        Assert.assertEquals(true, isValid(board, 0, 0));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, totalNQueens(4));
    }

    @Test
    public void test4() {
        Assert.assertEquals(92, totalNQueens(8));
    }

    @Test
    public void test5() {
        Assert.assertEquals(1, totalNQueens(1));
    }

    @Test
    public void test6() {
        Assert.assertEquals(0, totalNQueens(2));
    }
    @Test
    public void test7() {
        Assert.assertEquals(0, totalNQueens(0));
        Assert.assertEquals(0, totalNQueens(-1));
    }

}
