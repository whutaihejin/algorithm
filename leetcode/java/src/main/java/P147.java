import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-1.
 */
public class P147 {
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
        @Test
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

    private ListNode dummy = new ListNode(Integer.MIN_VALUE);

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        while (head != null) {
            ListNode next = head.next;
            ListNode forward = dummy.next, follow = dummy;
            for (; forward != null && forward.val < head.val; forward = forward.next, follow = follow.next) {
                // ignore
            }
            head.next = follow.next;
            follow.next = head;
            head = next;
        }
        return dummy.next;
    }

    @Test
    public void test0() {
        Assert.assertEquals(null, insertionSortList(null));
        ListNode head = new ListNode(1);
        Assert.assertEquals(head, insertionSortList(head));
    }

    @Test
    public void test2() {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals("1->2", n1.toString());
        ListNode head = insertionSortList(n1);
        Assert.assertEquals(1, head.val);
        Assert.assertEquals(2, head.next.val);
        Assert.assertEquals("1->2", head.toString());
    }

    @Test
    public void test3() {
        ListNode n3 = new ListNode(1);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(3, n2);
        Assert.assertEquals("3->2->1", n1.toString());
        ListNode head = insertionSortList(n1);
        Assert.assertEquals(1, head.val);
        Assert.assertEquals("1->2->3", head.toString());
    }

    @Test
    public void test4() {
        ListNode n4 = new ListNode(1);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(4, n2);
        Assert.assertEquals("4->3->2->1", n1.toString());
        ListNode head = insertionSortList(n1);
        Assert.assertEquals(1, head.val);
        Assert.assertEquals("1->2->3->4", head.toString());
    }
}
