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

    public ListNode reorderListHelper(ListNode head, ListNode[] dummy) {
        if (head.next == null) return head;
        ListNode node = reorderListHelper(head.next, dummy);
        if (dummy[0] == node || dummy[0].next == node) {
            node.next = null;
            return node;
        }
        ListNode next = dummy[0].next;
        node.next = dummy[0].next;
        dummy[0].next = node;
        dummy[0] = next;
        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        reorderListHelper(head, new ListNode[]{head});
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