package old; /**
 * Created by taihejin on 16-6-18.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51 {

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

    private String rowToString(char[][] board, int row) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            builder.append(board[row][i]);
        }
        return builder.toString();
    }

    private void doSolve(char[][] board, int row, List<List<String>> result) {
        int size = board.length;
        if (row == size) {
            List<String> list = new ArrayList<String>();
            for (int r = 0; r < board.length; r++) {
                list.add(rowToString(board, r));
            }
            result.add(list);
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

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                board[row][column] = EMPTY_CHAR;
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        doSolve(board, 0, result);
        return result;
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
        List<List<String>> reslut = solveNQueens(4);
        System.out.println(Arrays.deepToString(reslut.toArray()));
        Assert.assertEquals(2, reslut.size());
    }

    @Test
    public void test4() {
        List<List<String>> reslut = solveNQueens(8);
        Assert.assertEquals(92, reslut.size());
    }

}
