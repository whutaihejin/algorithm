package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-11.
 */
public class P117 {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
        TreeLinkNode(int x, TreeLinkNode left, TreeLinkNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return String.format("%d", val);
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode curr = root;
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            prev = null;
        }
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

    @Test
    public void test3() {
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode root = new TreeLinkNode(1, n2, null);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(null, n2.next);
    }

    @Test
    public void test4() {
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode root = new TreeLinkNode(1, null, n2);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(null, n2.next);
    }

    @Test
    public void test5() {
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n3 = new TreeLinkNode(3, n4, null);
        TreeLinkNode n2 = new TreeLinkNode(2, n3, null);
        TreeLinkNode root = new TreeLinkNode(1, n2, null);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(null, n2.next);
        Assert.assertEquals(null, n3.next);
        Assert.assertEquals(null, n4.next);
    }

    @Test
    public void test6() {
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n3 = new TreeLinkNode(3, null, n4);
        TreeLinkNode n2 = new TreeLinkNode(2, null, n3);
        TreeLinkNode root = new TreeLinkNode(1, null, n2);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(null, n2.next);
        Assert.assertEquals(null, n3.next);
        Assert.assertEquals(null, n4.next);
    }

    @Test
    public void test7() {
        //       1
        //     2   3
        //   4       5
        // 6           7
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n4 = new TreeLinkNode(4, n6, null);
        TreeLinkNode n2 = new TreeLinkNode(2, n4, null);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n5 = new TreeLinkNode(5, null, n7);
        TreeLinkNode n3 = new TreeLinkNode(3, null, n5);
        TreeLinkNode root = new TreeLinkNode(1, n2, n3);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(n3, n2.next);
        Assert.assertEquals(null, n3.next);
        Assert.assertEquals(n5, n4.next);
        Assert.assertEquals(null, n5.next);
        Assert.assertEquals(n7, n6.next);
        Assert.assertEquals(null, n7.next);
    }

    @Test
    public void test8() {
        //        1
        //      2     3
        //    4     5
        //  6     7
        //           8
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n7 = new TreeLinkNode(7, null, n8);
        TreeLinkNode n5 = new TreeLinkNode(5, n7, null);
        TreeLinkNode n3 = new TreeLinkNode(3, n5, null);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n4 = new TreeLinkNode(4, n6, null);
        TreeLinkNode n2 = new TreeLinkNode(2, n4, null);
        TreeLinkNode root = new TreeLinkNode(1, n2, n3);
        connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(n3, n2.next);
        Assert.assertEquals(null, n3.next);
        Assert.assertEquals(n5, n4.next);
        Assert.assertEquals(n7, n6.next);
        Assert.assertEquals(null, n7.next);
        Assert.assertEquals(null, n8.next);
    }

    @Test
    public void test9() {
        //          1
        //       2     3
        //     4   5     6
        //   7             8
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n6 = new TreeLinkNode(6, null, n8);
        TreeLinkNode n3 = new TreeLinkNode(3, null, n6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n4 = new TreeLinkNode(4, n7, null);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n2 = new TreeLinkNode(2, n4, n5);
        TreeLinkNode root = new TreeLinkNode(1, n2, n3);
        connect(root);
        Assert.assertEquals(n8, n7.next);
    }
}
