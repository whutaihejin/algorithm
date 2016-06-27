import org.junit.Test;

/**
 * Created by taihejin on 16-6-5.
 */
public class P21 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode n) { val = x; next = n; }

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



    private ListNode dummy = new ListNode(0, null);

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
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

    @Test
    public void test1() {
        ListNode node = new ListNode(2, null);
        System.out.println(node);
    }

    @Test
    public void test2() {
        ListNode n2 = new ListNode(2, null);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(n1);
    }

    @Test
    public void test3() {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode l1 = new ListNode(1, n2);
        ListNode m5 = new ListNode(10, null);
        ListNode m4 = new ListNode(9, m5);
        ListNode m3 = new ListNode(8, m4);
        ListNode m2 = new ListNode(7, m3);
        ListNode l2 = new ListNode(6, m2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    @Test
    public void test4() {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode l1 = new ListNode(1, n2);
        ListNode l2 = null;
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    @Test
    public void test5() {
        ListNode l1 = null;
        ListNode m5 = new ListNode(10, null);
        ListNode m4 = new ListNode(9, m5);
        ListNode m3 = new ListNode(8, m4);
        ListNode m2 = new ListNode(7, m3);
        ListNode l2 = new ListNode(6, m2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    @Test
    public void test6() {
        ListNode l1 = null;
        ListNode l2 = null;
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1, l2));
    }
}
