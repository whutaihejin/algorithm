package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem30T60Test {

    private Problem30T60 solution;

    public Problem30T60Test() {
        solution = new Problem30T60();
    }

    @Test
    public void nextPermutationTest() {
        int[] nums = new int[]{1, 2, 3};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 2}, nums);
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{2, 1, 3}, nums);
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{2, 3, 1}, nums);
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{3, 1, 2}, nums);
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{3, 2, 1}, nums);
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    public void longestValidParenthesesTest() {
        Assert.assertEquals(2, solution.longestValidParentheses("()"));
        Assert.assertEquals(0, solution.longestValidParentheses(""));
        Assert.assertEquals(0, solution.longestValidParentheses("((("));
        Assert.assertEquals(0, solution.longestValidParentheses(")))"));
        Assert.assertEquals(2, solution.longestValidParentheses("((()(("));
        Assert.assertEquals(4, solution.longestValidParentheses("((()(()()"));
    }

    @Test
    public void searchTest() {
        Assert.assertEquals(4, solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(0, solution.search(new int[]{4,5,6,7,0,1,2}, 4));
        Assert.assertEquals(1, solution.search(new int[]{4,5,6,7,0,1,2}, 5));
        Assert.assertEquals(6, solution.search(new int[]{4,5,6,7,0,1,2}, 2));
        Assert.assertEquals(1, solution.search(new int[]{3, 1}, 1));
    }

    @Test
    public void countAndSayTest() {
        Assert.assertEquals("1", solution.countAndSay(1));
        Assert.assertEquals("11", solution.countAndSay(2));
        Assert.assertEquals("21", solution.countAndSay(3));
        Assert.assertEquals("1211", solution.countAndSay(4));
        Assert.assertEquals("111221", solution.countAndSay(5));
        Assert.assertEquals("312211", solution.countAndSay(6));
    }

    @Test
    public void combinationSumTest() {
        List<List<Integer>> rst = solution.combinationSum(new int[]{2, 3, 5}, 8);
        Assert.assertEquals(3, rst.size());
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void combinationSumTest2() {
        List<List<Integer>> rst = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        Assert.assertEquals(2, rst.size());
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void combinationSum2Test() {
        List<List<Integer>> rst = solution.combinationSum2(new int[]{1, 5, 5}, 5);
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void permuteTest() {
        List<List<Integer>> rst = solution.permute(new int[]{1, 2, 3});
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void permuteUniqueTest() {
        List<List<Integer>> rst = solution.permuteUnique(new int[]{1, 1, 2, 2});
        Assert.assertEquals(6, rst.size());
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void permuteUniqueTest2() {
        List<List<Integer>> rst = solution.permuteUnique(new int[]{1, 1, 2});
        Assert.assertEquals(3, rst.size());
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void permuteUniqueTest3() {
        List<List<Integer>> rst = solution.permuteUnique(new int[]{1, 2, 3});
        Assert.assertEquals(6, rst.size());
        System.out.println("========");
        for (List<Integer> l : rst) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void firstMissingPositiveTest() {
        Assert.assertEquals(4, solution.firstMissingPositive(new int[]{1, 2, 3}));
        Assert.assertEquals(2, solution.firstMissingPositive(new int[]{1, 5, 3}));
        Assert.assertEquals(1, solution.firstMissingPositive(new int[]{10, 5, 3}));
    }

    @Test
    public void trapTest() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6, solution.trap(height));
    }

    @Test
    public void multiplyTest() {
        Assert.assertEquals("56088", solution.multiply("123", "456"));
        Assert.assertEquals("0", solution.multiply("", "456"));
        Assert.assertEquals("0", solution.multiply("123", ""));
        Assert.assertEquals("0", solution.multiply("123", "0"));
        Assert.assertEquals("0", solution.multiply("0", "123"));
        Assert.assertEquals("0", solution.multiply("0", "0"));
        Assert.assertEquals("0", solution.multiply("", ""));
    }

    @Test
    public void isMatchTest() {
        Assert.assertEquals(false, solution.isMatch("aa", "a"));
        Assert.assertEquals(true, solution.isMatch("aa", "*"));
        Assert.assertEquals(false, solution.isMatch("cb", "?a"));
        Assert.assertEquals(true, solution.isMatch("adceb", "*a*b"));
        Assert.assertEquals(false, solution.isMatch("acdcb", "a*c?b"));
    }

    @Test
    public void jumpTest() {
        Assert.assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void rotateTest() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix);
    }

    @Test
    public void myPowTest() {
        Assert.assertEquals(0.25, solution.myPow(2, -2), 0.0001);
    }

    @Test
    public void solveNQueensTest() {
        List<List<String>> rst = solution.solveNQueens(4);
        Assert.assertEquals(2, rst.size());
        for (List<String> list : rst) {
            System.out.println("==========");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void solveNQueensTest1() {
        List<List<String>> rst = solution.solveNQueens(5);
        // Assert.assertEquals(2, rst.size());
        for (List<String> list : rst) {
            System.out.println("==========");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void totalNQueensTest() {
        Assert.assertEquals(2, solution.totalNQueens(4));
    }

    @Test
    public void maxSubArrayTest() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assert.assertEquals(6, solution.maxSubArray(nums));
    }

    @Test
    public void canJumpTest() {
        int[] nums = new int[]{3,2,1,0,4,1};
        Assert.assertEquals(false, solution.canJump(nums));
    }

    public int[] rightLarge(int[] nums) {
        int[] large = new int[nums.length];
        Arrays.fill(large, -1);
        if (nums.length <= 0) return large;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                large[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        return large;
    }

    @Test
    public void rightLargeTest() {
        int[] nums = new int[]{3, 2, 5, 6, 1};
        int[] large = rightLarge(nums);
        for (int i : large) {
            System.out.print(i + " ");
        }
        Assert.assertArrayEquals(new int[]{5, 5, 6, -1, -1}, large);
    }

    @Test
    public void getPermutationTest() {
        Assert.assertEquals("123", solution.getPermutation(3, 1));
        Assert.assertEquals("132", solution.getPermutation(3, 2));
        Assert.assertEquals("213", solution.getPermutation(3, 3));
        Assert.assertEquals("231", solution.getPermutation(3, 4));
        Assert.assertEquals("312", solution.getPermutation(3, 5));
        Assert.assertEquals("321", solution.getPermutation(3, 6));
        Assert.assertEquals("1", solution.getPermutation(1, 1));
        Assert.assertEquals("12", solution.getPermutation(2, 1));
        Assert.assertEquals("21", solution.getPermutation(2, 2));
    }

    @Test
    public void rotateRightTest() {
        ListNode head = ListNode.Generator(5);
        Assert.assertEquals("1->2->3->4->5->NULL", head.toString());
        System.out.println(head.toString());
        ListNode h = solution.rotateRight(head, 2);
        Assert.assertEquals("4->5->1->2->3->NULL", h.toString());
    }

    @Test
    public void duplicateTest() {
        int[] nums = new int[]{2,3,1,0,2,5,3};
        int v = solution.duplicate(nums);
        Assert.assertEquals(2, v);
    }
}
