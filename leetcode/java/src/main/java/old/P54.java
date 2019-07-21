package old; /**
 * Created by taihejin on 16-6-18.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length < 1) {
            return list;
        }
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                list.add(matrix[top][c]);
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                list.add(matrix[r][right]);
            }
            right--;
            for (int c = right; c >= left && top <= bottom; c--) {
                list.add(matrix[bottom][c]);
            }
            bottom--;
            for (int r = bottom; r >= top && left <= right; r--) {
                list.add(matrix[r][left]);
            }
            left++;
        }
        return list;
    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", Arrays.toString(list.toArray()));
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1]", Arrays.toString(list.toArray()));
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 2, 3}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1, 2, 3]", Arrays.toString(list.toArray()));
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {1}, {2}, {3}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1, 2, 3]", Arrays.toString(list.toArray()));
    }

    @Test
    public void test5() {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1, 2, 3, 6, 5, 4]", Arrays.toString(list.toArray()));
    }

    @Test
    public void test6() {
        int[][] matrix = {
                {1, 2}, {3, 4}, {5, 6}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1, 2, 4, 6, 5, 3]", Arrays.toString(list.toArray()));
    }

    @Test
    public void test7() {
        int[][] matrix = {
                {1, 2}, {3, 4}};
        List<Integer> list = spiralOrder(matrix);
        Assert.assertEquals("[1, 2, 4, 3]", Arrays.toString(list.toArray()));
    }


}
