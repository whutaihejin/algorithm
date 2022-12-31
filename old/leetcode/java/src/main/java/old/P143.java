package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-1.
 */
public class P143 {

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
            return Integer.toString(val);
        }

        public String build() {
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

    private ListNode findMiddle(ListNode head) {
        ListNode follow = head;
        ListNode forward = head.next;
        while (forward != null && forward.next != null) {
            forward = forward.next.next;
            follow = follow.next;
        }
        return follow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode tail = findMiddle(head);
        ListNode l1 = head;
        ListNode l2 = tail.next;
        tail.next = null;
        l2 = reverse(l2);
        while (l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = next1;
            l2 = next2;
        }
    }

    @Test
    public void testfindMiddle0() {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2", n1.build());
        Assert.assertEquals(n1, findMiddle(n1));
        ListNode l1 = reverse(n1);
        Assert.assertEquals("2->1", l1.build());
    }

    @Test
    public void testFindMiddle1() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2->3", n1.build());
        Assert.assertEquals(n2, findMiddle(n1));
        ListNode l1 = reverse(n1);
        Assert.assertEquals("3->2->1", l1.build());
    }

    @Test
    public void testFindMiddle2() {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2->3->4", n1.build());
        Assert.assertEquals(n2, findMiddle(n1));
        ListNode l1 = reverse(n1);
        Assert.assertEquals("4->3->2->1", l1.build());
    }

    @Test
    public void testFindMiddle3() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2->3->4->5", n1.build());
        Assert.assertEquals(n3, findMiddle(n1));
    }

    @Test
    public void test0() {
        reorderList(null);
        ListNode head = new ListNode(1);
        reorderList(head);
        Assert.assertEquals("1", head.build());
    }

    @Test
    public void test1() {
        ListNode n2 = new ListNode(2);
        ListNode head = new ListNode(1, n2);
        reorderList(head);
        Assert.assertEquals("1->2", head.build());
    }

    @Test
    public void test2() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);
        reorderList(head);
        Assert.assertEquals("1->3->2", head.build());
    }

    @Test
    public void test3() {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reorderList(n1);
        Assert.assertEquals("1->6->2->5->3->4", n1.build());
    }

    @Test
    public void test4() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reorderList(n1);
        Assert.assertEquals("1->5->2->4->3", n1.build());
    }

    @Test
    public void test5() {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reorderList(n1);
        Assert.assertEquals("1->4->2->3", n1.build());
    }

}