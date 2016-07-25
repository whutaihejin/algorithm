import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by taihejin on 16-7-24.
 */
import java.util.List;

public class P95 {

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
        List<TreeNode> ret = generateTrees(1);
        Assert.assertEquals(1, ret.size());
        Assert.assertEquals(1, ret.get(0).val);
    }

    @Test
    public void test1() {
        List<TreeNode> ret = generateTrees(2);
        Assert.assertEquals(2, ret.size());
    }

    @Test
    public void test2() {
        List<TreeNode> ret = generateTrees(3);
        Assert.assertEquals(5, ret.size());
    }
}
