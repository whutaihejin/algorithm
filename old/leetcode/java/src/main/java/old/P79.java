package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-20.
 */
public class P79 {

    public boolean doSearch(char[][] board, boolean[][] visited, int x, int y, String word, int i) {
        if (i >= word.length()) {
            return true;
        }
        int row = board.length;
        int column = board[0].length;
        if (x < 0 || x >= row || y < 0 || y >= column /*boundary test*/
                || board[x][y] != word.charAt(i) || visited[x][y]) return false;
        visited[x][y] = true;
        boolean founded = doSearch(board, visited, x - 1, y, word, i + 1);
        if (!founded) founded = doSearch(board, visited, x, y + 1, word, i + 1);
        if (!founded) founded = doSearch(board, visited, x + 1, y, word, i + 1);
        if (!founded) founded = doSearch(board, visited, x, y - 1, word, i + 1);
        if (!founded) visited[x][y] = false;
        return founded;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        if (word.isEmpty() || board.length <= 0) return false;
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (doSearch(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test0() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertEquals(true, exist(board, "ABCCED"));
        Assert.assertEquals(true, exist(board, "SEE"));
        Assert.assertEquals(false, exist(board, "ABCB"));
        Assert.assertEquals(false, exist(board, "DD"));
        Assert.assertEquals(true, exist(board, "ECC"));
        Assert.assertEquals(true, exist(board, "CESE"));
    }
}
