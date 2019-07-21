package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-1.
 */
public class P148 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
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

    private ListNode dummy = new ListNode(-1);

    public ListNode findMiddle(ListNode head) {
        dummy.next = head;
        ListNode forward = head;
        ListNode follow = dummy;
        while (forward != null) {
            forward = forward.next;
            follow = follow.next;
            if (forward != null) {
                forward = forward.next;
            }
        }
        return follow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode l2 = middle.next;
        middle.next = null;
        ListNode sorted1 = sortList(head);
        ListNode sorted2 = sortList(l2);
        return merge(sorted1, sorted2);
    }

    @Test
    public void test0() {
        Assert.assertEquals(null, sortList(null));
        ListNode head = new ListNode(1);
        Assert.assertEquals(head, sortList(head));
    }

    @Test
    public void test1() {
        ListNode n2 = new ListNode(1);
        ListNode n1 = new ListNode(2, n2);
        ListNode head = sortList(n1);
        Assert.assertEquals(1, head.val);
    }

    @Test
    public void test2() {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = sortList(n1);
        Assert.assertEquals(1, head.val);
    }

    @Test
    public void test3() {
        ListNode n3 = new ListNode(1);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(3, n2);
        ListNode head = sortList(n1);
        Assert.assertEquals(1, head.val);
    }

    @Test
    public void test4() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = sortList(n1);
        Assert.assertEquals(1, head.val);
    }

    @Test
    public void test5() {
        ListNode n4 = new ListNode(1);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(4, n2);
        ListNode head = sortList(n1);
        Assert.assertEquals(1, head.val);
    }

    @Test
    public void test6() {
        ListNode n5 = new ListNode(1);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(5, n2);
        ListNode head = sortList(n1);
        Assert.assertEquals(1, head.val);
    }
}
