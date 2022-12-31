package old;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by taihejin on 16-7-22.
 */
public class P85 {

    private int largestRectangleArea(char[] heights) {
        int area = 0;
        char[] postHeights = Arrays.copyOf(heights, heights.length + 1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < postHeights.length; i++) {
            if (stack.isEmpty() || (int) postHeights[stack.peek()] <= (int) postHeights[i]) {
                stack.push(i);
            } else {
                int index = stack.pop();
                area = Math.max(area, (int) postHeights[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = 0; c < matrix[0].length; c++) {
                int count = 0;
                while (r - count >= 0 && matrix[r - count][c] == '1') count++;
                matrix[r][c] = (char) count;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(matrix[r]));
        }
        return maxArea;
    }

    public void doTest(int val) {
        char ch = (char) val;
        Assert.assertEquals(val, (int) ch);
    }

    @Test
    public void test0() {
        for (int i = 0; i < 65535; i++) {
            doTest(i);
        }
    }

    @Test
    public void test1() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Assert.assertEquals(6, maximalRectangle(matrix));
    }

    @Test
    public void test2() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
        };
        Assert.assertEquals(1, maximalRectangle(matrix));
    }

    @Test
    public void test3() {
        char[][] matrix = {
                {'1'},
        };
        Assert.assertEquals(1, maximalRectangle(matrix));
    }

    @Test
    public void test4() {
        char[][] matrix = {
                {'0'},
        };
        Assert.assertEquals(0, maximalRectangle(matrix));
    }

    @Test
    public void test5() {
        char[][] matrix = {
                {},
        };
        Assert.assertEquals(0, maximalRectangle(matrix));
    }

    @Test
    public void test6() {
        char[][] matrix = {
                {'1'},
                {'0'},
                {'1'},
                {'1'}
        };
        Assert.assertEquals(2, maximalRectangle(matrix));
    }


}
