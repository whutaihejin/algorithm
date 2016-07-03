import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-7-3.
 */
public class P61 {

    public static class  ListNode {
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

    public ListNode arrayToList(int[] array) {
        if (array == null || array.length < 1) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int item : array) {
            ListNode node = new ListNode(item);
            tail.next = node;
            tail = node;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return head;
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

    public ListNode findReversedKth(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode forward = dummy;
        ListNode follow = dummy;
        for (int i = 0; i < k && forward != null; i++) {
            forward = forward.next;
        }
        while (forward != null) {
            forward = forward.next;
            follow = follow.next;
        }
        return follow != dummy ? follow : null;
    }


    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size += 1;
        }
        k %= size;
        ListNode boundary =  findReversedKth(head, k + 1);
        ListNode l2 = null;
        if (boundary != null) {
            l2 = boundary.next;
            boundary.next = null;
        }
        ListNode rl1 = reverse(head);
        ListNode rl2 = reverse(l2);
        ListNode tail = findReversedKth(rl1, 1);
        if (tail != null) {
            tail.next = rl2;
        } else {
            rl1 = rl2;
        }
        return reverse(rl1);
    }

    @Test
    public void test1() {
        Assert.assertEquals(null, arrayToList(null));
        Assert.assertEquals(null, arrayToList(new int[0]));
    }

    @Test
    public void test2() {
        Assert.assertEquals("1->2->3->4->5", arrayToList(new int[]{1, 2, 3, 4, 5}).toString());
    }

    @Test
    public void test3() {
        ListNode list = arrayToList(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals("5->1->2->3->4", rotateRight(list, 1).toString());
        list = arrayToList(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals("4->5->1->2->3", rotateRight(list, 2).toString());
        list = arrayToList(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals("3->4->5->1->2", rotateRight(list, 3).toString());
        list = arrayToList(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals("2->3->4->5->1", rotateRight(list, 4).toString());
        list = arrayToList(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals("1->2->3->4->5", rotateRight(list, 5).toString());
        list = arrayToList(new int[]{1, 2, 3, 4, 5});
        System.out.println(rotateRight(list, 0).toString());
        list = arrayToList(new int[]{1, 2, 3, 4, 5});
        System.out.println(rotateRight(list, 5).toString());
     }

    @Test
    public void test4() {
        ListNode list = arrayToList(new int[]{1, 2});
        Assert.assertEquals("2->1", rotateRight(list, 3).toString());
    }


}
