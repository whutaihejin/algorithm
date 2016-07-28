import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by taihejin on 16-7-26.
 */
public class P99 {

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

    public void recoverTree(TreeNode root) {
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(64);
        TreeNode spot = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (spot == null) {
                if (prev.val > curr.val) {
                    spot = prev;
                }
            } else if (curr.val > spot.val) {
                break;
            }
            prev = curr;
            root = curr.right;
        }
        if (spot != null && prev != null) {
            int tmp = spot.val;
            spot.val = prev.val;
            prev.val = tmp;
        }
    }

    public boolean isValidBST(TreeNode root) {
        long prev = Integer.MIN_VALUE - 1L;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(32);
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            if (top.val <= prev) {
                return false;
            }
            prev = top.val;
            root = top.right;
        }
        return true;
    }

    @Test
    public void test0() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5, n4, null);
        TreeNode root = new TreeNode(3, n2, n5);
        recoverTree(root);
        Assert.assertEquals(true, isValidBST(root));
    }

    @Test
    public void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5, n4, null);
        TreeNode root = new TreeNode(3, n2, n5);
        recoverTree(root);
        Assert.assertEquals(true, isValidBST(root));
    }

    @Test
    public void test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(5, n1, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2, n4, null);
        TreeNode root = new TreeNode(3, n2, n5);
        recoverTree(root);
        Assert.assertEquals(true, isValidBST(root));
    }

    @Test
    public void test3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5, n4, null);
        TreeNode root = new TreeNode(4, n2, n5);
        recoverTree(root);
        Assert.assertEquals(true, isValidBST(root));
    }

    @Test
    public void test4() {
        Assert.assertEquals(true, isValidBST(null));
    }

    @Test
    public void test5() {
        Assert.assertEquals(true, isValidBST(new TreeNode(1)));
    }
}
