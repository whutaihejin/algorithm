package old; /**
 * Created by taihejin on 16-7-26.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode nil = new TreeNode(0);
        queue.offer(root);
        queue.offer(nil);
        List<Integer> level = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            if (item != nil) {
                level.add(item.val);
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            } else if (!queue.isEmpty()){
                ret.add(new ArrayList<Integer>(level));
                level.clear();
                queue.offer(nil);
            }
        }
        ret.add(level);
        return ret;
    }

    @Test
    public void test0() {
        Assert.assertEquals(true, levelOrder(null).isEmpty());
        Assert.assertEquals(1, levelOrder(new TreeNode(1)).size());
    }

    @Test
    public void test1() {
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 =  new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);
        Assert.assertEquals(3, levelOrder(root).size());
    }

    @Test
    public void test2() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        Assert.assertEquals(2, levelOrder(root).size());
    }

    @Test
    public void test3() {
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(2, levelOrder(root).size());
    }

    @Test
    public void test4() {
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, null, n3);
        Assert.assertEquals(2, levelOrder(root).size());
    }

    @Test
    public void test5() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, null);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode root = new TreeNode(1, n2, null);
        Assert.assertEquals(4, levelOrder(root).size());
    }

}
