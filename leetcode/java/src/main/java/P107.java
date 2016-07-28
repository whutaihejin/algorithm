/**
 * Created by taihejin on 16-7-27.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P107 {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        TreeNode nil = new TreeNode(-1);
        List<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        queue.offer(nil);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head != nil) {
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            } else if (!queue.isEmpty()) {
                ret.add(new ArrayList<Integer>(level));
                level.clear();
                queue.offer(nil);
            }
        }
        ret.add(level);
        Collections.reverse(ret);
        return ret;
    }

    @Test
    public void test0() {
        List<List<Integer>> ret = levelOrderBottom(null);
        Assert.assertEquals(true, ret.isEmpty());
    }

    @Test
    public void test1() {
        List<List<Integer>> ret = levelOrderBottom(new TreeNode(1));
        Assert.assertEquals(1, ret.size());
    }

    public void test2() {
        List<List<Integer>> ret = levelOrderBottom(null);
    }
}
