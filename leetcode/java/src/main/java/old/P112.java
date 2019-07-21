package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P112 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }

    public boolean doPathSum(TreeNode root, int sum) {
        if (root == null) return sum == 0;
        int expect = sum - root.val;
        if (root.left == null) {
            return doPathSum(root.right, expect);
        }
        if (root.right == null) {
            return doPathSum(root.left, expect);
        }
        return doPathSum(root.left, expect) ? true : doPathSum(root.right, expect);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return doPathSum(root, sum);
    }

    @Test
    public void test0() {
        Assert.assertEquals(false, hasPathSum(null, 0));
        Assert.assertEquals(false, hasPathSum(null, 1));
        Assert.assertEquals(true, hasPathSum(new TreeNode(3), 3));
        Assert.assertEquals(false, hasPathSum(new TreeNode(3), 1));
        Assert.assertEquals(false, hasPathSum(new TreeNode(3), 5));
    }

    @Test
    public void test100() {
        // 1
        //   2
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, n2);
        Assert.assertEquals(false, hasPathSum(root, 1));
//        Assert.assertEquals(true, hasPathSum(root, 3));
    }

    @Test
    public void test1() {
        //     1
        //  2     3
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(true, hasPathSum(root, 3));
        Assert.assertEquals(true, hasPathSum(root, 4));
        Assert.assertEquals(false, hasPathSum(root, 2));
        Assert.assertEquals(false, hasPathSum(root, 5));
    }

    @Test
    public void test2() {
        //        5
        //     4     8
        //  11     13  4
        // 7   2          1
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n11 = new TreeNode(11, n7, n2);
        TreeNode n4 = new TreeNode(4, n11, null);
        TreeNode n1 = new TreeNode(1);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4r = new TreeNode(4, null, n1);
        TreeNode n8 = new TreeNode(8, n13, n4r);
        TreeNode root = new TreeNode(5, n4, n8);
        Assert.assertEquals(true, hasPathSum(root, 22));
        Assert.assertEquals(true, hasPathSum(root, 18));
        Assert.assertEquals(true, hasPathSum(root, 26));
        Assert.assertEquals(true, hasPathSum(root, 27));
        Assert.assertEquals(true, hasPathSum(root, 22));
        Assert.assertEquals(false, hasPathSum(root, 10));
        Assert.assertEquals(false, hasPathSum(root, 5));
    }

}
