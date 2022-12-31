package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-26.
 */
public class P101 {

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

    public boolean judgeSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null) {
            return rightRoot == null;
        }
        if (rightRoot == null || leftRoot.val != rightRoot.val) {
            return false;
        }
        return judgeSymmetric(leftRoot.left, rightRoot.right) && judgeSymmetric(leftRoot.right, rightRoot.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return judgeSymmetric(root, root);
    }

    @Test
    public void test0() {
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2, n6, n7);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(true, isSymmetric(root));
    }

    @Test
    public void test1() {
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, null, n5);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(4);
        TreeNode n3 = new TreeNode(2, null, n7);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(false, isSymmetric(root));
    }

    @Test
    public void test2() {
        Assert.assertEquals(true, isSymmetric(null));
        Assert.assertEquals(true, isSymmetric(new TreeNode(1)));
    }

    @Test
    public void test3() {
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(false, isSymmetric(root));
    }
}
