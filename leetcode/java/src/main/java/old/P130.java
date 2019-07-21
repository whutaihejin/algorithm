package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-11.
 */
public class P130 {

    private static final char O_CHAR = 'O';
    private static final char C_CHAR = 'C';
    private static final char X_CHAR = 'X';

    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 0) return;
        int column = board[0].length;
        if (column <= 0) return;
        for (int r = 0; r < row; r++) {
            check(board, r, 0);
            if (column > 1) {
                check(board, r, column - 1);
            }
        }
        for (int c = 0; c < column; c++) {
            check(board, 0, c);
            if (row > 1) {
                check(board, row - 1, c);
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (board[r][c] == O_CHAR) {
                    board[r][c] = X_CHAR;
                }
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (board[r][c] == C_CHAR) {
                    board[r][c] = O_CHAR;
                }
            }
        }
    }

    private void check(char[][] board, int r, int c) {
        if (board[r][c] == O_CHAR) {
            board[r][c] = C_CHAR;
            if (r > 1) {
                check(board, r - 1, c);
            }
            if (c > 1) {
                check(board, r, c - 1);
            }
            if (r + 1 < board.length) {
                check(board, r + 1, c);
            }
            if (c + 1 < board[0].length) {
                check(board, r, c + 1);
            }
        }
    }

    @Test
    public void test0() {
        char[][] board = new char[4][];
        board[0] = "XXXX".toCharArray();
        board[1] = "XOOX".toCharArray();
        board[2] = "XXOX".toCharArray();
        board[3] = "XOXX".toCharArray();
        solve(board);
        Assert.assertEquals("XXXX", new String(board[0]));
        Assert.assertEquals("XXXX", new String(board[1]));
        Assert.assertEquals("XXXX", new String(board[2]));
        Assert.assertEquals("XOXX", new String(board[3]));
    }
}
