package base;

/**
 * Created by taihejin on 16-6-22.
 */
public class RedBlackTree {

    private enum Color { RED, BLACK};

    private static class Node {
        private int key;
        private Color color;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int key, Color color, Node left, Node right, Node parent) {
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node() {
            this(0, Color.RED, null, null, null);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append('[').append(key).append(',')
                    .append(' ').append(color).append(']');
            return builder.toString();
        }
    }

    private Node nil = new Node();
    private Node root;

    public RedBlackTree() {
        root = nil;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        // put y's left to x's right
        x.right = y.left;
        if (y != nil) {
            y.parent = x;
        }
        // put y to x's parent

    }
}
