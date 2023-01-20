package week_5;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root = null;

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<>();
        for (int i = 1; i < 16; i++) {
            redBlackBST.insert(i, i);
        }

        redBlackBST.levelOrder();

    }

    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;
        int count;

        public Node(Key k, Value v, boolean color) {
            this.key = k;
            this.value = v;
            this.color = color;
            this.count = 1;
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (x == null) return;

        inorder(x.left);
        System.out.print(x.value + " ");
        inorder(x.right);
    }


    public void levelOrder() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                if (queue.isEmpty()) break;
                else {
                    queue.add(null);
                    System.out.println(" ");
                    continue;
                }
            }

            System.out.print(current.value + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }


    public Node search(Key key) {
        return search(root, key);
    }

    private Node search(Node x, Key key) {
        if (x == null) return null;

        int comp = key.compareTo(x.key);
        if (comp < 0) return search(x.left, key);
        else if (comp > 0) return search(x.right, key);
        else return x;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    private Node insert(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, RED);
        int comp = key.compareTo(x.key);
        if (comp < 0) x.left = insert(x.left, key, value);
        else if (comp > 0) x.right = insert(x.right, key, value);
        else x.value = value;


        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.right) && isRed(x.left)) flipColors(x);

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left) && isRed(h.right);

        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
