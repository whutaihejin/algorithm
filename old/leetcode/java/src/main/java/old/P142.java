package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-5.
 */
public class P142 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode n) {
            this.val = x;
            this.next = n;
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

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode forward = head, follow = head;
        boolean isCycle = false;
        while (forward.next != null && forward.next.next != null) {
            forward = forward.next.next;
            follow = follow.next;
            if (forward == follow) {
                isCycle = true;
                forward = head;
                break;
            }
        }
        if (!isCycle) return null;
        while (forward != follow) {
            forward = forward.next;
            follow = follow.next;
        }
        return forward;
    }

    @Test
    public void test0() {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n7.next = n4;
        Assert.assertEquals(n4, detectCycle(n1));
    }

    @Test
    public void test1() {
        ListNode n11 = new ListNode(11);
        ListNode n10 = new ListNode(10, n11);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n11.next = n9;
        Assert.assertEquals(n9, detectCycle(n1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(null, detectCycle(null));
    }

    @Test
    public void test3() {
        ListNode n11 = new ListNode(11);
        ListNode n10 = new ListNode(10, n11);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals(null, detectCycle(n1));
    }
}
