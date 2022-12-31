package old; /**
 * Created by taihejin on 16-7-24.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

public class P94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>(32);
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(32);
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            ret.add(top.val);
            root = top.right;
        }
        return ret;
    }

    @Test
    public void test0() {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n2;
        root.right = n3;
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.left = n6;
        n3.right = n7;
        TreeNode n8 = new TreeNode(8);
        n4.right = n8;
        List<Integer> ret = inorderTraversal(root);
        Assert.assertEquals(4, ret.get(0).intValue());
        Assert.assertEquals(8, ret.get(1).intValue());
        Assert.assertEquals(2, ret.get(2).intValue());
        Assert.assertEquals(5, ret.get(3).intValue());
        Assert.assertEquals(1, ret.get(4).intValue());
        Assert.assertEquals(6, ret.get(5).intValue());
        Assert.assertEquals(3, ret.get(6).intValue());
        Assert.assertEquals(7, ret.get(7).intValue());
    }

    @Test
    public void test1() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, null);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode root = new TreeNode(1, n2, null);
        List<Integer> ret = inorderTraversal(root);
        Assert.assertEquals(4, ret.get(0).intValue());
        Assert.assertEquals(3, ret.get(1).intValue());
        Assert.assertEquals(2, ret.get(2).intValue());
        Assert.assertEquals(1, ret.get(3).intValue());
    }

    @Test
    public void test2() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n2 = new TreeNode(2, null, n3);
        TreeNode root = new TreeNode(1, null, n2);
        List<Integer> ret = inorderTraversal(root);
        Assert.assertEquals(4, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
        Assert.assertEquals(2, ret.get(1).intValue());
        Assert.assertEquals(3, ret.get(2).intValue());
        Assert.assertEquals(4, ret.get(3).intValue());
    }

    @Test
    public void test3() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n2 = new TreeNode(2, null, n3);
        TreeNode root = new TreeNode(1, n2, null);
        List<Integer> ret = inorderTraversal(root);
        Assert.assertEquals(4, ret.size());
        Assert.assertEquals(2, ret.get(0).intValue());
        Assert.assertEquals(3, ret.get(1).intValue());
        Assert.assertEquals(4, ret.get(2).intValue());
        Assert.assertEquals(1, ret.get(3).intValue());
    }

    @Test
    public void test4() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, null);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode root = new TreeNode(1, null, n2);
        List<Integer> ret = inorderTraversal(root);
        Assert.assertEquals(4, ret.size());
        Assert.assertEquals(1, ret.get(0).intValue());
        Assert.assertEquals(4, ret.get(1).intValue());
        Assert.assertEquals(3, ret.get(2).intValue());
        Assert.assertEquals(2, ret.get(3).intValue());
    }
}
