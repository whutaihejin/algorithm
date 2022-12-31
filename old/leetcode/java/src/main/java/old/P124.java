package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-12.
 */
public class P124 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
        public TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("%d", val);
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] ref = {Integer.MIN_VALUE};
        maxPathSumHelper(root, ref);
        return ref[0];

    }

    private int maxPathSumHelper(TreeNode root, int[] ref) {
        if (root == null) return 0;
        int leftMax = maxPathSumHelper(root.left, ref);
        int rightMax = maxPathSumHelper(root.right, ref);
        int max = root.val;
        if (leftMax > 0) max += leftMax;
        if (rightMax > 0) max += rightMax;
        ref[0] = Math.max(ref[0], max);
        int val = Math.max(leftMax, rightMax);
        return  root.val + (val > 0 ? val : 0);
    }

    @Test
    public void test0() {
        TreeNode root = new TreeNode(11);
        Assert.assertEquals(11, maxPathSum(root));
        root = new TreeNode(-3);
        Assert.assertEquals(-3, maxPathSum(root));
    }

    @Test
    public void test1() {
        //   1
        // 2   3
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(6, maxPathSum(root));
    }

    @Test
    public void test2() {
        //   -1
        // 2   -100
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-100);
        TreeNode root = new TreeNode(-1, left, right);
        Assert.assertEquals(2, maxPathSum(root));
    }

    @Test
    public void test3() {
        //   1
        // -200   -100
        TreeNode left = new TreeNode(-2);
        TreeNode right = new TreeNode(-100);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(1, maxPathSum(root));
    }

    @Test
    public void test4() {
        //   -1
        // -2    5
        TreeNode left = new TreeNode(-2);
        TreeNode right = new TreeNode(5);
        TreeNode root = new TreeNode(-1, left, right);
        Assert.assertEquals(5, maxPathSum(root));
    }

    @Test
    public void test5() {
        //    1
        // 2    -1
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-1);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(3, maxPathSum(root));
    }

    @Test
    public void test6() {
        //     1
        // -2     3
        TreeNode left = new TreeNode(-2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(4, maxPathSum(root));
    }

    @Test
    public void test7() {
        //     1
        // 2      3
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(6, maxPathSum(root));
    }

    @Test
    public void test8() {
        //     1
        //    1
        //   1
        // -10
        TreeNode n4 = new TreeNode(-10);
        TreeNode n3 = new TreeNode(1, n4, null);
        TreeNode n2 = new TreeNode(1, n3, null);
        TreeNode n1 = new TreeNode(1, n2, null);
        Assert.assertEquals(3, maxPathSum(n1));
    }

    @Test
    public void test9() {
        //     1
        //    -20
        //   10
        // -10
        TreeNode n4 = new TreeNode(-10);
        TreeNode n3 = new TreeNode(10, n4, null);
        TreeNode n2 = new TreeNode(-20, n3, null);
        TreeNode n1 = new TreeNode(1, n2, null);
        Assert.assertEquals(10, maxPathSum(n1));
    }

    @Test
    public void test10() {
        //       1
        //   2      3
        // 4   5  6   7
        TreeNode n4 = new TreeNode(10);
        TreeNode n5 = new TreeNode(20);
        TreeNode n2 = new TreeNode(30, n4, n5);
        TreeNode n6 = new TreeNode(-1);
        TreeNode n7 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-1, n6, n7);
        TreeNode root = new TreeNode(-2, n2, n3);
        Assert.assertEquals(60, maxPathSum(root));
    }

}