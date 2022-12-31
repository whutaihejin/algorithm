package algorithm;


public class ListNode {
    public ListNode(int v) {
        this.val = v;
    }
    public int val;
    public ListNode next;

    @Override
    public String toString() {
        ListNode p = this;
        StringBuilder b = new StringBuilder();
        while (p != null) {
            b.append(String.format("%d->", p.val));
            p = p.next;
        }
        b.append("NULL");
        return b.toString();
    }

    public static ListNode Generator(int k) {
        if (k <= 0) return null;
        ListNode head = new ListNode(1);
        ListNode tail = head;
        for (int i = 1; i < k; ++i) {
            ListNode node = new ListNode(i + 1);
            tail.next = node;
            tail = node;
        }
        return head;
    }
}
