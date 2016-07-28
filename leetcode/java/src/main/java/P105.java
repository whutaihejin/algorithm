import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-26.
 */
public class P105 {

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

    public TreeNode doBuildTree(int[] preorder, int i, int[] inorder, int j, int length) {
        if (length <= 0) return null;
        int offset = 0;
        while (offset < length && inorder[j + offset] != preorder[i]) offset++;
        TreeNode left = doBuildTree(preorder, i + 1, inorder, j, offset);
        TreeNode right = doBuildTree(preorder, i + offset + 1, inorder, j + offset + 1, length - offset - 1);
        TreeNode root = new TreeNode(preorder[i]);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return doBuildTree(preorder, 0, inorder, 0, preorder.length);
    }

    @Test
    public void test0() {
        TreeNode root = buildTree(new int[]{1}, new int[]{1});
        Assert.assertEquals(1, root.val);
    }

    @Test
    public void test1() {
        TreeNode root = buildTree(new int[]{1, 3, 5, 4, 7, 8}, new int[]{3, 1, 7, 4, 8, 5});
        Assert.assertEquals(1, root.val);
    }

    @Test
    public void test2() {
        TreeNode root = buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
        Assert.assertEquals(1, root.val);
    }

    @Test
    public void test3() {
        TreeNode root = buildTree(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
        Assert.assertEquals(1, root.val);
    }

    @Test
    public void test4() {
        TreeNode root = buildTree(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        Assert.assertEquals(1, root.val);
    }

    @Test
    public void test5() {
        TreeNode root = buildTree(new int[]{}, new int[]{});
        Assert.assertEquals(null, root);
    }
}
