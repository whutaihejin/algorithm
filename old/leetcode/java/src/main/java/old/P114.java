package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */

public class P114 {

    private TreeNode next = null;

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

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }

    public void convert(TreeNode root, TreeNode[] prev) {
        if (root == null) return;
        convert(root.left, prev);
        if (prev[0] != null) {
            prev[0].right = root;
        }
        root.left = prev[0];
        prev[0] = root;
        convert(root.right, prev);
    }

    public TreeNode BST2DL(TreeNode root) {
        if (root == null) return root;
        convert(root, new TreeNode[] {null});
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    @Test
    public void test0() {
        flatten(null);
        TreeNode root = new TreeNode(1);
        flatten(root);
    }

    @Test
    public void test1() {
        //   1
        // 2
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, null);
        flatten(root);
    }

    @Test
    public void test2() {
        // 1
        //   2
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, n2);
        flatten(root);
    }

    @Test
    public void test3() {
        //   1
        // 2   3
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        flatten(root);
    }

    @Test
    public void test4() {
        //     1
        //  2      3
        //4   5  6   7
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode root = new TreeNode(1, n2, n3);
        flatten(root);
    }

    @Test
    public void test5() {
        //     1
        //  2      3
        //4   5  6   7
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode root = new TreeNode(1, n2, n3);
        TreeNode head = BST2DL(root);
        Assert.assertEquals(4, head.val);
    }




}
