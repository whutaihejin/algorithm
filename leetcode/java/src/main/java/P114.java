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

    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            root = top.right;
        }
        TreeNode prev = new TreeNode(-1);
        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            curr.left = null;
            curr.right = null;
            prev.right = curr;
            prev = curr;
        }
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
