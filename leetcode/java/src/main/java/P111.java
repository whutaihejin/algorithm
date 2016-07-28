import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P111 {

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

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null)
            return minDepth(root.right)  + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, minDepth(null));
        Assert.assertEquals(1, minDepth(new TreeNode(1)));
    }

    @Test
    public void test1() {
        //  1
        // 2 3
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(2, minDepth(root));
    }

    @Test
    public void test2() {
        //  1
        //    3
        TreeNode n2 = null;
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(2, minDepth(root));
    }

    @Test
    public void test3() {
        //  1
        // 2
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = null;
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(2, minDepth(root));
    }

    @Test
    public void test4() {
        //  1
        // 2 3
        //    4
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(2, minDepth(root));
    }
}
