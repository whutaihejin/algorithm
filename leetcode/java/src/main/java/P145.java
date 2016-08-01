import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) return ret;\
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ret.add(root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode top = stack.pop();
            root = top.left;
        }
        Collections.reverse(ret);
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

    @Test
    public void test5() {
        //       1
        //   2       3
        // 4   5   6   7
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode root = new TreeNode(1, n2, n3);
        List<Integer> ret = postorderTraversal(root);
        Assert.assertEquals("[4, 5, 2, 6, 7, 3, 1]", Arrays.toString(ret.toArray()));
    }

}
