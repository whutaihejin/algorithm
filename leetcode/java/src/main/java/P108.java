import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P108 {

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

    public TreeNode buildBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int middle = low + (high - low) / 2;
        TreeNode left = buildBST(nums, low, middle - 1);
        TreeNode right = buildBST(nums, middle + 1, high);
        TreeNode root = new TreeNode(nums[middle]);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    @Test
    public void test0() {
        TreeNode root = sortedArrayToBST(new int[]{});
        Assert.assertEquals(null, root);
    }

    @Test
    public void test1() {
        TreeNode root = sortedArrayToBST(new int[]{1});
        Assert.assertEquals(root.val, 1);
    }

    @Test
    public void test2() {
        TreeNode root = sortedArrayToBST(new int[]{1, 2});
        Assert.assertEquals(root.val, 1);
    }

    @Test
    public void test3() {
        TreeNode root = sortedArrayToBST(new int[]{1, 2, 3});
        Assert.assertEquals(2, root.val);
    }
}
