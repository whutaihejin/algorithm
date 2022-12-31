package old;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by taihejin on 16-8-15.
 */
public class P146 {

    public static class LRUCache {

        private static class DListNode {
            private int key;
            private int value;
            private DListNode prev;
            private DListNode next;
            public DListNode(int key, int value){
                this.key = key;
                this.value = value;
            }
            public void set(int value) {
                this.value = value;
            }
            @Override
            public String toString() {
                return String.format("%d", value);
            }
        }

        private static class Entry {
            private int key;
            private DListNode node;
            private Entry next;
            public Entry(int key, DListNode node, Entry next) {
                this.key = key;
                this.node = node;
                this.next = next;
            }
            public Entry(int key, DListNode node) {
                this(key, node, null);
            }
        }

        private DListNode dummy = new DListNode(-1, -1);
        private DListNode tail = dummy;
        private Entry[] hash = null;
        private int capacity = 1;
        private int filled = 0;

        public LRUCache(int capacity) {
            this.capacity = Math.max(this.capacity, capacity);
            hash = new Entry[this.capacity];
        }

        public int get(int key) {
            int index = Math.max(key, -key) % capacity;
            Entry p = hash[index];
            int value = -1;
            while (p != null) {
                if (p.key == key) {
                    remove(p.node);
                    pushHead(p.node);
                    value = p.node.value;
                    break;
                }
                p = p.next;
            }
            return value;
        }

        public void set(int key, int value) {
            int index = Math.max(key, -key) % capacity;
            Entry p = hash[index];
            while (p != null && p.key != key) {
                p = p.next;
            }
            if (p == null) { // not found or the hash[index] is null
                filled++;
                DListNode node = new DListNode(key, value);
                Entry entry = new Entry(key, node);
                if (filled > capacity) {
                    filled--;
                    removeTail();
                }
                pushHead(node);
                if (hash[index] == null) {
                    hash[index] = entry;
                } else {
                    Entry e = hash[index];
                    entry.next = e.next;
                    e.next = entry;
                }
            } else {
                p.node.set(value);
                remove(p.node);
                pushHead(p.node);
            }
        }

        private void remove(DListNode node) {
            if (node == tail) { // remove tail
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
            node.prev.next = node.next;
        }

        private void pushHead(DListNode node) {
            if (tail == dummy) { // empty list
                tail = node;
            } else {
                dummy.next.prev = node;
            }
            node.next = dummy.next;
            node.prev = dummy;
            dummy.next = node;
        }

        private void removeTail() {
            DListNode node = tail;
            remove(node);
            int index = Math.max(node.key, -node.key) % capacity;
            Entry p = hash[index];
            if (p.node != node) {
                while (p.next != null && p.next.node != node) {
                    p = p.next;
                }
                p.next = p.next.next;
            } else {
                hash[index] = p.next;
            }
        }
    }

    @Test
    public void test0() {
        LRUCache lru = new LRUCache(4);
        Assert.assertEquals(-1, lru.get(-2));
        Assert.assertEquals(-1, lru.get(-1));
        Assert.assertEquals(-1, lru.get(0));
        Assert.assertEquals(-1, lru.get(1));
        Assert.assertEquals(-1, lru.get(2));
    }

    @Test
    public void test1() {
        LRUCache lru = new LRUCache(4);
        lru.set(1, 2);
        Assert.assertEquals(2, lru.get(1));
        lru.set(1, 3);
        Assert.assertEquals(3, lru.get(1));
    }

    @Test
    public void test2() {
        LRUCache lru = new LRUCache(4);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        Assert.assertEquals(4, lru.get(4));
        lru.set(5, 5);
        Assert.assertEquals(-1, lru.get(1));
        Assert.assertEquals(4, lru.get(4));
        Assert.assertEquals(5, lru.get(5));
    }

    @Test
    public void test3() {
        LRUCache lru = new LRUCache(1);
        lru.set(2, 1);
        Assert.assertEquals(1, lru.get(2));
        lru.set(3, 2);
        Assert.assertEquals(-1, lru.get(2));
        lru.set(5, 1);
        Assert.assertEquals(-1, lru.get(3));
        Assert.assertEquals(1, lru.get(5));
    }

    @Test
    public void test4() {
        LRUCache lru = new LRUCache(2);
        lru.set(2, 1);
        lru.set(2, 2);
        Assert.assertEquals(2, lru.get(2));
        lru.set(1, 1);
        lru.set(4, 1);
        Assert.assertEquals(1, lru.get(1));
        Assert.assertEquals(1, lru.get(4));
        Assert.assertEquals(-1, lru.get(2));
    }
}
