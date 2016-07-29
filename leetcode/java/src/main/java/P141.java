import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-28.
 */
public class P141 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode forward = head, follow = head;
        while (forward.next != null && forward.next.next != null) {
            forward = forward.next.next;
            follow = follow.next;
            if (forward == follow) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test0() {
        Assert.assertEquals(false, hasCycle(null));
        Assert.assertEquals(false, hasCycle(new ListNode(1)));
    }

    @Test
    public void test1() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        Assert.assertEquals(false, hasCycle(n1));
        n5.next = n3;
        Assert.assertEquals(true, hasCycle(n1));
    }
}
