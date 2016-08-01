import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by taihejin on 16-8-1.
 */
public class P145 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    private void postorderTraversalHelper(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        postorderTraversalHelper(root.left, ret);
        postorderTraversalHelper(root.right, ret);
        ret.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        postorderTraversalHelper(root, ret);
        return ret;
    }

    @Test
    public void test0() {
        List<Integer> ret = postorderTraversal(null);
        Assert.assertEquals("[]", Arrays.toString(ret.toArray()));
    }

    @Test
    public void test1() {
        List<Integer> ret = postorderTraversal(new TreeNode(1));
        Assert.assertEquals("[1]", Arrays.toString(ret.toArray()));
    }

    @Test
    public void test2() {
        //  1
        // 2
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        List<Integer> ret = postorderTraversal(root);
        Assert.assertEquals("[2, 1]", Arrays.toString(ret.toArray()));
    }

    @Test
    public void test3() {
        //  1
        //    2
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, right);
        List<Integer> ret = postorderTraversal(root);
        Assert.assertEquals("[2, 1]", Arrays.toString(ret.toArray()));
    }

    @Test
    public void test4() {
        //   1
        // 2   3
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        List<Integer> ret = postorderTraversal(root);
        Assert.assertEquals("[2, 3, 1]", Arrays.toString(ret.toArray()));
    }

}
