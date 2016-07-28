import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-27.
 */
public class P106 {

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

    private TreeNode doBuildTree(int[] inorder, int i, int[] postorder, int j, int length) {
        if (length <= 0) return null;
        int offset = 0;
        while (/*offset < length && */inorder[i + offset] != postorder[j  + length - 1]) offset++;
        TreeNode left = doBuildTree(inorder, i, postorder, j, offset);
        TreeNode right = doBuildTree(inorder, i + offset + 1, postorder, j + offset, length - offset - 1);
        TreeNode root = new TreeNode(postorder[j + length - 1]);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return doBuildTree(inorder, 0, postorder, 0, inorder.length);
    }

    @Test
    public void test0() {
        TreeNode root = buildTree(new int[]{3, 1, 7, 4, 8, 5}, new int[]{3, 7, 8, 4, 5, 1});
        Assert.assertEquals(1, root.val);
    }

    @Test
    public void test1() {
        TreeNode root = buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1});
        Assert.assertEquals(1, root.val);
    }
}
