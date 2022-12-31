package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P110 {

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

    private static class Spy {
        int height;
        boolean isBalanced;
        public Spy(int h, boolean b) {
            height = h;
            isBalanced = b;
        }
    }

    public Spy judgeBalance(TreeNode root) {
        if (root == null) return new Spy(0, true);
        Spy left = judgeBalance(root.left);
        Spy right = judgeBalance(root.right);
        boolean balance = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        return new Spy(Math.max(left.height, right.height) + 1, balance);
    }

    public boolean isBalanced(TreeNode root) {
        Spy spy = judgeBalance(root);
        return spy.isBalanced;
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, isBalanced(null));
        Assert.assertEquals(true, isBalanced(new TreeNode(1)));
    }

    @Test
    public void test1() {
        TreeNode left = null;
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        Assert.assertEquals(true, isBalanced(root));
    }

    @Test
    public void test2() {
        TreeNode left = new TreeNode(1);
        TreeNode right = null;
        TreeNode root = new TreeNode(2);
        Assert.assertEquals(true, isBalanced(root));
    }

    @Test
    public void test3() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2);
        Assert.assertEquals(true, isBalanced(root));
    }

    @Test
    public void test4() {
        //     1
        //  2     3
        //       4  5
        //            6
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, n5);
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(false, isBalanced(root));
    }

    @Test
    public void test5() {
        //     1
        //  2     3
        //       4  5
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, n5);
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(true, isBalanced(root));
    }

    @Test
    public void test6() {
        //     1
        //  2     3
        //   -1  4  5
        //            6
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, n5);
        TreeNode n2 = new TreeNode(2, null, new TreeNode(-1));
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(true, isBalanced(root));
    }

}
