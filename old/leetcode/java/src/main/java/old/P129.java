package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-12.
 */
public class P129 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("%d", val);
        }
    }

    public int sumNumbers(TreeNode root) {
        int[] ref = {0};
        sumNumbersHelper(root, 0, ref);
        return ref[0];
    }

    private void sumNumbersHelper(TreeNode root, int val, int[] ref) {
        if (root == null) return;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            ref[0] += val;
            return;
        }
        sumNumbersHelper(root.left, val, ref);
        sumNumbersHelper(root.right, val, ref);
    }

    @Test
    public void test0() {
        TreeNode root = new TreeNode(9);
        Assert.assertEquals(9, sumNumbers(root));
    }

    @Test
    public void test1() {
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        Assert.assertEquals(12, sumNumbers(root));
    }

    @Test
    public void test2() {
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, null, right);
        Assert.assertEquals(13, sumNumbers(root));
    }

    @Test
    public void test3() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(25, sumNumbers(root));
    }

    @Test
    public void test4() {
        //     1
        //    1
        //   1
        //  1
        // 1
        TreeNode n5 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1, n5, null);
        TreeNode n3 = new TreeNode(1, n4, null);
        TreeNode n2 = new TreeNode(1, n3, null);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(11111, sumNumbers(root));
    }

    @Test
    public void test5() {
        // 1
        //  1
        //   1
        //    1
        //     1
        TreeNode n5 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1, null, n5);
        TreeNode n3 = new TreeNode(1, null, n4);
        TreeNode n2 = new TreeNode(1, null, n3);
        TreeNode root = new TreeNode(1, null, n2);
        Assert.assertEquals(11111, sumNumbers(root));
    }

    @Test
    public void test6() {
        //   1
        // 2   4
        //       3
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4, null, n3);
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, n4);
        Assert.assertEquals(155, sumNumbers(root));
    }

    @Test
    public void test7() {
        //   1
        // 2     4
        //     1   3
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4, n1, n3);
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, n4);
        Assert.assertEquals(296, sumNumbers(root));
    }
}