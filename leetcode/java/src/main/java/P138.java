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

    public RandomListNode copyRandomListHelper(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (head == null) return head;
        if (map.containsKey(head)) return map.get(head);
        RandomListNode copy = new RandomListNode(head.label);
        map.put(head, copy);
        copy.next = copyRandomListHelper(head.next, map);
        copy.random = copyRandomListHelper(head.random, map);
        return copy;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        return copyRandomListHelper(head, map);
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
