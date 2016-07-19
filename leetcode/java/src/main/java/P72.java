import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-19.
 */
public class P72 {

    public int minDistance(String word1, String word2) {
        word1 = word1 != null ? word1 : "";
        word2 = word2 != null ? word2 : "";
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();
        int row = word1.length() + 1;
        int column = word2.length() + 1;
        int[][] D = new int[row][column];
        for (int c = 0; c < column; c++) {
            D[0][c] = c;
        }
        for (int r = 0; r < row; r++) {
            D[r][0] = r;
        }
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < column; c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    D[r][c] = D[r - 1][c - 1];
                } else {
                    int d = D[r - 1][c]; // delete
                    d = Math.min(d, D[r - 1][c - 1]); // replace
                    d = Math.min(d, D[r][c - 1]); // insert
                    D[r][c] = d + 1;
                }
            }
        }
        return D[row - 1][column - 1];
    }

    @Test
    public void test0() {
        Assert.assertEquals(3, minDistance("", "123"));
        Assert.assertEquals(3, minDistance("123", ""));
        Assert.assertEquals(2, minDistance("123", "1"));
        Assert.assertEquals(2, minDistance("1", "123"));
        Assert.assertEquals(1, minDistance("12", "123"));
        Assert.assertEquals(0, minDistance("123", "123"));
        Assert.assertEquals(1, minDistance("123456789", "12346789"));
    }
}
