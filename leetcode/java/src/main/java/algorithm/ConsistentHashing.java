package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    // Entry class
    public static class Entry {
        private String key;
        public Entry(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key;
        }
    }

    // Server class
    public static class Server {
        private String name;
        private Map<Entry, Entry> cache;

        public Server(String name) {
            this.name = name;
            cache = new HashMap<>();
        }

        public void put(Entry e) {
            cache.put(e, e);
        }

        public Entry get(Entry e) {
            return cache.get(e);
        }
    }

    public interface Cluster {
        Entry get(Entry e);
        boolean put(Entry entry);
        boolean addServer(Server s);
    }

    // Cluster class
    public static class NaiveCluster implements Cluster {
        private static final int CLUSTER_SIZE = 1024;
        private Server[] servers = new Server[CLUSTER_SIZE];
        private int capacity = 0;

        public Entry get(Entry e) {
            if (capacity <= 0) return null;
            return servers[e.hashCode() % capacity].get(e);
        }

        public boolean put(Entry entry) {
            if (capacity <= 0) return false;
            servers[entry.hashCode() % capacity].put(entry);
            return true;
        }

        public boolean addServer(Server s) {
            if (capacity >= CLUSTER_SIZE) return false;
            servers[capacity++] = s;
            return true;
        }
    }

    //
    public static class ConsistentHashingCluster implements Cluster {
        private static final int CLUSTER_SIZE = 1024;

        private SortedMap<Integer, Server> servers = new TreeMap<>();
        private int capacity = 0;

        private Server route(int hash) {
            if (!servers.containsKey(hash)) {
                SortedMap<Integer, Server> tail = servers.tailMap(hash);
                hash = tail.isEmpty() ? servers.firstKey() : tail.firstKey();
            }
            return servers.get(hash);
        }

        public Entry get(Entry e) {
            if (capacity <= 0) return null;
            return route(e.hashCode()).get(e);
        }

        public boolean put(Entry entry) {
            if (capacity <= 0) return false;
            route(entry.hashCode()).put(entry);
            return true;
        }

        public boolean addServer(Server s) {
            if (capacity >= CLUSTER_SIZE) return false;
            servers.put(s.hashCode(), s);
            capacity++;
            return true;
        }
    }

    public static void createCluster(Cluster c) {
        c.addServer(new Server("192.168.0.0"));
        c.addServer(new Server("192.168.0.1"));
        c.addServer(new Server("192.168.0.2"));
        c.addServer(new Server("192.168.0.3"));
        c.addServer(new Server("192.168.0.4"));
        c.addServer(new Server("192.168.0.5"));
    }

    private static void findEntries(Cluster c, Entry[] entries) {
        for (Entry e : entries) {
            if (e == c.get(e)) {
                System.out.println("重新找到了entry:" + e);
            } else {
                System.out.println("entry已失效:" + e);
            }
        }
    }

    public static void main(String[] args) {
        Entry[] entries = {
                new Entry("i"),
                new Entry("have"),
                new Entry("a"),
                new Entry("pen"),
                new Entry("an"),
                new Entry("apple"),
                new Entry("applepen"),
                new Entry("pineapple"),
                new Entry("pineapplepen"),
                new Entry("PPAP")
        };

        {
            Cluster c = new NaiveCluster();
            createCluster(c);
            for (Entry e : entries) {
                c.put(e);
            }
            System.out.println("1 ====");
            findEntries(c, entries);
            c.addServer(new Server("192.168.0.6"));
            System.out.println("2 ====");
            findEntries(c, entries);
        }

        {
            Cluster c = new ConsistentHashingCluster();
            createCluster(c);
            for (Entry e : entries) {
                c.put(e);
            }
            System.out.println("1 ====");
            findEntries(c, entries);
            c.addServer(new Server("192.168.0.6"));
            System.out.println("2 ====");
            findEntries(c, entries);
        }
    }
}
