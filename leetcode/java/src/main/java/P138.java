import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taihejin on 16-8-10.
 */
public class P138 {

    private static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }

        @Override
        public String toString() {
            return String.format("%d@0x%x", label, this.hashCode());
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        Map<RandomListNode, RandomListNode> hash = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            copy.random = p.random;
            hash.put(p, copy);
            p = p.next;
        }
        p = hash.get(head);
        while (p != null) {
            p.next = hash.get(p.next);
            p.random = hash.get(p.random);
            p = p.next;
        }
        return hash.get(head);
    }

    @Test
    public void test0() {
        Assert.assertEquals(null, copyRandomList(null));
    }

    @Test
    public void test1() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n1;
        RandomListNode copy = copyRandomList(n1);
        Assert.assertEquals(2, copy.next.label);
    }

}
