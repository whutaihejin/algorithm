package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-24.
 */
public class P92 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null, curr = dummy;
        for (int i = 0; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode left = prev;
        // move
        prev = curr;
        curr = curr.next;
        for (int i = m + 1; i <= n; i++) {
            ListNode next = curr.next;
            prev.next = next;
            // insert
            curr.next = left.next;
            left.next = curr;
            // move
            curr = next;
        }
        return dummy.next;
    }

    public ListNode reverseBetweenIterator(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null, curr = dummy, left, right;
        // walk to the right position
        for (int i = 0; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        // record the position
        left = prev;
        right = curr;
        // begin to reverse
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        left.next = prev;
        right.next = curr;
        return dummy.next;
    }

    @Test
    public void test0() {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2->3->4->5", n1.toString());
        ListNode head = reverseBetween(n1, 2, 4);
        Assert.assertEquals("1->4->3->2->5", head.toString());
    }

    @Test
    public void test1() {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2->3->4->5", n1.toString());
        ListNode head = reverseBetween(n1, 2, 2);
        Assert.assertEquals("1->2->3->4->5", head.toString());
    }

    @Test
    public void test2() {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2->3->4->5", n1.toString());
        ListNode head = reverseBetween(n1, 1, 5);
        Assert.assertEquals("5->4->3->2->1", head.toString());
    }
}
