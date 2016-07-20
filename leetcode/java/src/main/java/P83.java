import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-20.
 */
public class P83 {

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
        ListNode tail = head;
        ListNode p = head.next;
        tail.next = null;
        while (p != null) {
            if (p.val == tail.val) {
                p = p.next;
            } else {
                tail.next = p;
                p = p.next;
                tail = tail.next;
                tail.next = null;
            }
        }
        return head;
    }

    @Test
    public void test0() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        Assert.assertEquals("1->2->3", n1.toString());
    }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        Assert.assertEquals("1", n1.toString());
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        Assert.assertEquals("1->2", n1.toString());
    }

    @Test
    public void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        Assert.assertEquals("1->2->3->3", n1.toString());
        ListNode head = deleteDuplicates(n1);
        Assert.assertEquals("1->2->3", head.toString());
    }

    @Test
    public void test4() {
        Assert.assertEquals(null, deleteDuplicates(null));
        ListNode head = new ListNode(1);
        Assert.assertEquals(head, deleteDuplicates(head));
    }
}
