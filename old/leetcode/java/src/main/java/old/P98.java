package old;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by taihejin on 16-7-25.
 */
public class P98 {

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

    public List<TreeNode> doGenerateTrees(int low, int high) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (high < low) {
            ret.add(null);
            return ret;
        }
        for (int k = low; k <= high; k++) {
            List<TreeNode> left = doGenerateTrees(low, k - 1);
            List<TreeNode> right = doGenerateTrees(k + 1, high);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(k);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return doGenerateTrees(1, n);
    }

    @Test
    public void test0() {
        for (int i = 0; i < 4; i++) {
            for (TreeNode root : generateTrees(i)) {
                Assert.assertEquals(true, isValidBST(root));
            }
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, isValidBST(null));
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(false, isValidBST(root));
    }

    @Test
    public void test2() {
        Assert.assertEquals(true, isValidBST(null));
        TreeNode left = new TreeNode(Integer.MIN_VALUE);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        Assert.assertEquals(true, isValidBST(root));
    }

}
