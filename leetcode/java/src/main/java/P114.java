import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.transaction.TransactionRequiredException;
import java.util.*;

/**
 * Created by taihejin on 16-7-28.
 */

public class P114 {

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

    public void flattenHelper(TreeNode root, TreeNode[] next) {
        if (root == null) return;
        flattenHelper(root.right, next);
        flattenHelper(root.left, next);
        root.right = next[0];
        root.left = null;
        next[0] = root;
    }

    public void flatten(TreeNode root) {
        flattenHelper(root, new TreeNode[]{null});
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




}
