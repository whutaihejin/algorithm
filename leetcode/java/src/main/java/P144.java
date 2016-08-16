/**
 * Created by taihejin on 16-8-1.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P144 {
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

    private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) return ret;
        stack.clear();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                ret.add(root.val);
                root = root.left;
            }
            TreeNode top = stack.pop();
            root = top.right;
        }
        return ret;
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, preorderTraversal(null).isEmpty());
        List<Integer> ret = preorderTraversal(new TreeNode(1));
        Assert.assertEquals(1, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
    }

    @Test
    public void test1() {
        //   1
        // 2
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        List<Integer> ret = preorderTraversal(root);
        Assert.assertEquals("[1, 2]", Arrays.toString(ret.toArray()));
    }

    @Test
    public void test2() {
        //  1
        //    2
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, right);
        List<Integer> ret = preorderTraversal(root);
        Assert.assertEquals("[1, 2]", Arrays.toString(ret.toArray()));
    }

    @Test
    public void test3() {
        //   1
        // 2   3
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        List<Integer> ret = preorderTraversal(root);
        Assert.assertEquals("[1, 2, 3]", Arrays.toString(ret.toArray()));
    }

}
