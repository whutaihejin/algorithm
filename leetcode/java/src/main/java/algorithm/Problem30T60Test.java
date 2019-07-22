package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
}
