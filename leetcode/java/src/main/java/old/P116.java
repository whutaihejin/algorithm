package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P116 {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
            this.next = nil;
        }
        TreeLinkNode(int x, TreeLinkNode left, TreeLinkNode right) {
            val = x;
            this.left = left;
            this.right = right;
            this.next = nil;
        }
    }

    private static final TreeLinkNode nil = new TreeLinkNode(-1);

    private void connectHelper(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) return;
        root.next = next;
        connectHelper(root.left, root.right);
        connectHelper(root.right, next != null ? next.left : next);
    }

    public void connect(TreeLinkNode root) {
        connectHelper(root, null);
    }

    @Test
    public void test0() {
        connect(null);
        TreeLinkNode root = new TreeLinkNode(1);
        connect(root);
        Assert.assertEquals(null, root.next);
    }

    @Test
    public void test1() {
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        TreeLinkNode root = new TreeLinkNode(1, left, right);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(right, left.next);
        Assert.assertEquals(null, right.next);
    }

    @Test
    public void test2() {
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n2 = new TreeLinkNode(2, n4, n5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n3 = new TreeLinkNode(3, n6, n7);
        TreeLinkNode root = new TreeLinkNode(1, n2, n3);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(n3, n2.next);
        Assert.assertEquals(null, n3.next);
        Assert.assertEquals(n5, n4.next);
        Assert.assertEquals(n6, n5.next);
        Assert.assertEquals(n7, n6.next);
        Assert.assertEquals(null, n7.next);
    }

}
