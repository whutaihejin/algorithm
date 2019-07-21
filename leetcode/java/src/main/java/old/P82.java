package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-20.
 */
public class P82 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }

        @Override
        public String toString() {
            StringBuilder  builder = new StringBuilder();
            ListNode p = this;
            while (p.next != null) {
                builder.append(p.val).append('-').append('>');
                p = p.next;
            }
            builder.append(p.val);
            return builder.toString();
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode p = head;
        ListNode tail = dummy;
        while (p != null) {
            if (p.next == null || p.next.val != p.val) {
                tail.next = p;
                p = p.next;
                tail = tail.next;
                tail.next = null;
            } else {
                ListNode q = p.next;
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                p = q;
            }
        }
        return dummy.next;
    }

    @Test
    public void test0() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        ListNode head = deleteDuplicates(n1);
        Assert.assertEquals("1->2", head == null ? null : head.toString());
    }
}
