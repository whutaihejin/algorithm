package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-26.
 */
public class P104 {

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

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, maxDepth(null));
        Assert.assertEquals(1, maxDepth(new TreeNode(0)));
    }

    @Test
    public void test1() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(2, maxDepth(root));
    }

    @Test
    public void test2() {
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(2, maxDepth(root));
    }

    @Test
    public void test3() {
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        Assert.assertEquals(2, maxDepth(root));
    }

    @Test
    public void test4() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, null, n3);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(3, maxDepth(root));
    }

    @Test
    public void test5() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(3, maxDepth(root));
    }
}
