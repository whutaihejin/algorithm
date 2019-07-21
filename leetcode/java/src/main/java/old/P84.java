package old;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by taihejin on 16-7-21.
 */
public class P84 {

    // 枚举法
    public int method1(int[] heights) {
        int area = 0;
        for (int right = 0; right < heights.length; right++) {
            int minHight = heights[right];
            for (int left = right; left >= 0; left--) {
                minHight = Math.min(minHight, heights[left]);
                area = Math.max(area, minHight * (right - left + 1));
            }
        }
        return area;
    }

    // 对枚举法的初步优化
    public int method2(int[] heights) {
        int area = 0;
        for (int right = 0; right < heights.length; right++) {
            int limit = right + 1;
            while (limit < heights.length && heights[right] <= heights[limit]) {
                right++;
                limit++;
            }
            int minHeight = heights[right];
            for (int left = right; left >= 0; left--) {
                minHeight = Math.min(minHeight, heights[left]);
                area = Math.max(area, minHeight * (right - left + 1));
            }
        }
        return area;
    }

    // 使用栈进行终极优化
    public int method3(int[] heights) {
        int area = 0;
        int[] postHeights = Arrays.copyOf(heights, heights.length + 1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < postHeights.length; i++) {
            if (stack.isEmpty() || postHeights[stack.peek()] <= postHeights[i]) {
                stack.push(i);
            } else {
                int index = stack.pop();
                area = Math.max(area, postHeights[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        return area;
    }

    public int largestRectangleArea(int[] heights) {
        return method3(heights);
    }

    @Test
    public void testCopy() {
        int[] arr = {1, 2};
        int[] copyed = Arrays.copyOf(arr, arr.length + 1);
        Assert.assertEquals(1, copyed[0]);
        Assert.assertEquals(2, copyed[1]);
    }

    @Test
    public void test0() {
        int[] hights = {2,1,5,6,2,3};
        Assert.assertEquals(10, largestRectangleArea(hights));
    }

    @Test
    public void test1() {
        int[] heights = {1, 2, 3, 4};
        Assert.assertEquals(6, largestRectangleArea(heights));
    }

    @Test
    public void test2() {
        int[] heights = {1, 2, 3, 4, 1};
        Assert.assertEquals(6, largestRectangleArea(heights));
    }

    @Test
    public void test3() {
        int[] heights = {3, 4, 2, 1};
        Assert.assertEquals(6, largestRectangleArea(heights));
    }

    @Test
    public void test4() {
        int[] heights = {};
        Assert.assertEquals(0, largestRectangleArea(heights));
    }

    @Test
    public void test5() {
        int[] heights = {4,2,0,3,2,5};
        Assert.assertEquals(6, largestRectangleArea(heights));
    }
}
