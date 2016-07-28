import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P109 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            ListNode p = this;
            while (p.next != null) {
                builder.append(p.val).append("->");
                p = p.next;
            }
            builder.append(p.val);
            return builder.toString();
        }
    }

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

    public ListNode cutMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode follow = dummy;
        ListNode forward = head;
        ListNode prev = null;
        while (forward != null) {
            prev = follow;
            forward = forward.next;
            follow = follow.next;
            if (forward != null) {
                forward = forward.next;
            }
        }
        if (prev != null) {
            prev.next = null;
        }
        return follow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode middle = cutMiddle(head);
        TreeNode left = sortedListToBST(middle == head ? null : head);
        TreeNode right = sortedListToBST(middle.next);
        TreeNode root = new TreeNode(middle.val);
        root.left = left;
        root.right = right;
        return root;
    }

    @Test
    public void test0() {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);
        Assert.assertEquals("1->2->3->4->5", head.toString());
        ListNode middle = cutMiddle(head);
        Assert.assertEquals(n3, middle);            
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode middle = cutMiddle(head);
        Assert.assertEquals("1", middle.toString());
    }

    @Test
    public void test2() {
        ListNode n2 = new ListNode(2);
        ListNode head = new ListNode(1, n2);
        ListNode middle = cutMiddle(head);
        Assert.assertEquals(1, middle.val);
    }

    @Test
    public void test3() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);
        ListNode middle = cutMiddle(head);
        Assert.assertEquals(2, middle.val);
    }

    @Test
    public void test4() {
        TreeNode root = sortedListToBST(null);
        Assert.assertEquals(null, root);
    }

    @Test
    public void test5() {
        TreeNode root = sortedListToBST(new ListNode(1));
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(null, root.left);
        Assert.assertEquals(null, root.right);
    }

    @Test
    public void test6() {
        ListNode n2 = new ListNode(2);
        ListNode head = new ListNode(1, n2);
        TreeNode root = sortedListToBST(head);
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(null, root.left);
        Assert.assertEquals(2, root.right.val);
    }

    @Test
    public void test7() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        TreeNode root = sortedListToBST(n1);
        Assert.assertEquals(2, root.val);
        Assert.assertEquals(1, root.left.val);
        Assert.assertEquals(3, root.right.val);
    }

    @Test
    public void test8() {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        TreeNode root = sortedListToBST(n1);
        Assert.assertEquals(2, root.val);
        Assert.assertEquals(1, root.left.val);
        Assert.assertEquals(3, root.right.val);
    }

}
