package base;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by taihejin on 16-6-25.
 */
public class BinaryTree {

    public static class Node {

        private char key;
        private Node left;
        private Node right;

        public Node(char key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append('{').append(key).append('}');
            return builder.toString();
        }
    }

    private Node root;

    public BinaryTree() {
        Node g = new Node('G', null, null);
        Node d = new Node('D', null, g);
        Node b = new Node('B', d, null);

        Node e = new Node('E', null, null);
        Node f = new Node('F', null, null);
        Node c = new Node('C', e, f);

        root = new Node('A', b, c);
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + ", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.key + ", ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.key + ", ");
    }

    public void levelTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node item = queue.poll();
            System.out.print(item.key + ", ");
            if (item.left != null) {
                queue.offer(item.left);
            }
            if (item.right != null) {
                queue.offer(item.right);
            }
        }
    }

    public void reverse(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        root.left = root.right;
        root.right = left;
        reverse(root.left);
        reverse(root.right);
    }

    public void preTraversal(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<Node>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.key + ", ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public void inTraversal(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<Node>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.key + ", ");
                root = root.right;
            }
        }
    }

    @Test
    public void test1() {
        System.out.print("pre order: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("pre order: ");
        preTraversal(root);
        System.out.println();

    }

    @Test
    public void test2() {
        System.out.print("in order: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.print("in order: ");
        inTraversal(root);
        System.out.println();
    }

    @Test
    public void test3() {
        System.out.print("post order: ");
        postOrderTraversal(root);
        System.out.println();
    }

    @Test
    public void test4() {
        System.out.print("level order: ");
        levelTraversal(root);
        System.out.println();
    }

    @Test
    public void test5() {
        reverse(root);
        levelTraversal(root);
    }

    public Node build(char[] pre, char[] in, int i, int j, int size) {
        if (size <= 0) {
            return null;
        } else if (size == 1) {
            return new Node(pre[i], null, null);
        }
        int k = j;
        for (; k < j + size; k++) {
            if (in[k] == pre[i]) {
                break;
            }
        }
        Node left = build(pre, in, i + 1, j, k - j);
        Node right = build(pre, in, i + k - j + 1, k + 1, size - (k - j + 1));
        return new Node(pre[i], left, right);
    }

    @Test
    public void test6() {
        char[] pre = {'A', 'B', 'D', 'G', 'C', 'E', 'F'};
        char[] in = {'D', 'G', 'B', 'A', 'E', 'C', 'F'};
        Node root = build(pre, in, 0, 0, pre.length);
        System.out.println("level");
        levelTraversal(root);
        System.out.println("pre");
        preTraversal(root);
        System.out.println("in");
        inTraversal(root);

    }
}
