package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-21.
 */
public class P86 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

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

    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        // low list
        ListNode lowDummy = new ListNode(0);
        lowDummy.next = null;
        ListNode lowTail = lowDummy;
        // high list
        ListNode highDummy = new ListNode(0);
        highDummy.next = null;
        ListNode highTail = highDummy;
        while (head != null) {
            if (head.val < x) {
                lowTail.next = head;
                head = head.next;
                lowTail = lowTail.next;
                lowTail.next = null;
            } else {
                highTail.next = head;
                head = head.next;
                highTail = highTail.next;
                highTail.next = null;
            }
        }
        lowTail.next = highDummy.next;
        return lowDummy.next;
    }

    @Test
    public void test0() {
        Assert.assertEquals(null, partition(null, 0));
        ListNode head = new ListNode(1);
        Assert.assertEquals(head, partition(head, 1));
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(2);
        n5.next = n6;
        Assert.assertEquals("1->4->3->2->5->2", head.toString());
        ListNode l = partition(head, 3);
        Assert.assertEquals("1->2->2->4->3->5", l.toString());
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(2);
        n5.next = n6;
        Assert.assertEquals("1->4->3->2->5->2", head.toString());
        ListNode l = partition(head, 1);
        Assert.assertEquals("1->4->3->2->5->2", l.toString());
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(2);
        n5.next = n6;
        Assert.assertEquals("1->4->3->2->5->2", head.toString());
        ListNode l = partition(head, 4);
        Assert.assertEquals("1->3->2->2->4->5", l.toString());
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(2);
        n5.next = n6;
        Assert.assertEquals("1->4->3->2->5->2", head.toString());
        ListNode l = partition(head, 5);
        Assert.assertEquals("1->4->3->2->2->5", l.toString());
    }
}
