package old; /**
 * Created by taihejin on 16-7-28.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P113 {

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

    public void doPathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ret) {
        if (root == null) {
            if (sum == 0) ret.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(root.val);
        int index = path.size() - 1;
        int expect = sum - root.val;
        if (root.left == null) {
            doPathSum(root.right, expect, path, ret);
            path.remove(index);
            return;
        }
        if (root.right == null) {
            doPathSum(root.left, expect, path, ret);
            path.remove(index);
            return;
        }
        doPathSum(root.left, expect, path, ret);
        doPathSum(root.right, expect, path, ret);
        path.remove(index);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        List<Integer> path = new ArrayList<Integer>();
        doPathSum(root, sum, path, ret);
        return ret;
    }

    @Test
    public void test0() {
        List<List<Integer>> ret = pathSum(null, 1);
        Assert.assertEquals(true, ret.isEmpty());
    }

    @Test
    public void test1() {
        List<List<Integer>> ret = pathSum(new TreeNode(1), 1);
        Assert.assertEquals(1, ret.size());
    }

    @Test
    public void test2() {
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, n2);
        List<List<Integer>> ret = pathSum(root, 1);
        Assert.assertEquals(true, ret.isEmpty());
        List<List<Integer>> result = pathSum(root, 3);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void test3() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, right);
        List<List<Integer>> ret = pathSum(root, 3);
        Assert.assertEquals(2, ret.size());
    }

    @Test
    public void test4() {
        //        5
        //     4     8
        //  11     13  4
        // 7   2          1
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n11 = new TreeNode(11, n7, n2);
        TreeNode n4 = new TreeNode(4, n11, null);
        TreeNode n1 = new TreeNode(1);
        TreeNode n13 = new TreeNode(13);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4r = new TreeNode(4, n5, n1);
        TreeNode n8 = new TreeNode(8, n13, n4r);
        TreeNode root = new TreeNode(5, n4, n8);
        List<List<Integer>> ret = pathSum(root, 22);
        Assert.assertEquals(2, ret.size());
    }

}
