/**
 * Created by taihejin on 16-8-9.
 */
import org.junit.Test;

import java.util.*;

public class P133 {

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

        @Override
        public String toString() {
            return String.format("%d@0x%x", label, this.hashCode());
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        Deque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            UndirectedGraphNode copy = new UndirectedGraphNode(head.label);
            copy.neighbors = new ArrayList<UndirectedGraphNode>(head.neighbors);
            map.put(head, copy);
            for (UndirectedGraphNode e : head.neighbors) {
                if (!map.containsKey(e)) {
                    queue.offer(e);
                }
            }
        }
        UndirectedGraphNode copiedHead = map.get(node);
        queue.offer(copiedHead);
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode mapNode = map.get(head.neighbors.get(i));
                if (mapNode == null) continue;
                head.neighbors.set(i, mapNode);
                if (!visited.contains(mapNode)) {
                    queue.offer(mapNode);
                    visited.add(mapNode);
                }
            }
        }
        return copiedHead;
    }

    @Test
    public void test0() {
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        n0.neighbors = Arrays.asList(n1, n2);
        n1.neighbors = Arrays.asList(n2);
        n2.neighbors = Arrays.asList(n2);
        UndirectedGraphNode copyedHead = cloneGraph(n0);
    }

    @Test
    public void test1() {
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        n0.neighbors.add(n0);
        n0.neighbors.add(n0);
        UndirectedGraphNode copyedHead = cloneGraph(n0);
    }
}
