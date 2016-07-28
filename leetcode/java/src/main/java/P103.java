import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by taihejin on 16-7-26.
 */
public class P103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
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
        for (int i = 0; i < ret.size(); i++) {
            if ((i & 0x01) == 0x01) {
                List<Integer> e = ret.get(i);
                Collections.reverse(e);
            }
        }
        return ret;
    }

    @Test
    public void test0() {
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 =  new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);
        List<List<Integer>> ret = zigzagLevelOrder(root);
        Assert.assertEquals(3, ret.size());
    }

    @Test
    public void test1() {
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 =  new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n12 = new TreeNode(12);
        TreeNode n9 = new TreeNode(9, n8, n12);
        TreeNode root = new TreeNode(3, n9, n20);
        List<List<Integer>> ret = zigzagLevelOrder(root);
        Assert.assertEquals(3, ret.size());
    }
}
