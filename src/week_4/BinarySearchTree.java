package week_4;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root = null;

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
        int[] a = new int[]{12, 6, 22, 4, 20, 2, 24, 8, 16, 10, 14, 18, 26};

        for (int j : a) {
            binarySearchTree.insert(j, String.valueOf(j));
        }

        for (int i = 2; i <= 26; i += 2) {
            System.out.print(binarySearchTree.search(i) + " ");
        }

        System.out.println(" ");
        int minKey = binarySearchTree.minNode().key;
        String minValue = binarySearchTree.minNode().value;
        System.out.println(minKey + " " + minValue);

        int maxKey = binarySearchTree.maxNode().key;
        String maxValue = binarySearchTree.maxNode().value;
        System.out.println(maxKey + " " + maxValue);

        System.out.println(binarySearchTree.floor(21).value);
        System.out.println(binarySearchTree.ceil(21).value);

        System.out.println(binarySearchTree.size());

        System.out.println(binarySearchTree.rank(6));
        System.out.println(binarySearchTree.rank(20));
        System.out.println(binarySearchTree.rank(2));
        System.out.println(binarySearchTree.rank(26));

        System.out.println(binarySearchTree.select(11).value);
        binarySearchTree.inorder();
        System.out.println(" ");
        binarySearchTree.levelOrder();
        System.out.println(" ");

        binarySearchTree.delete(20);

        binarySearchTree.inorder();
    }

    private class Node {
        Key key;
        Value value;
        int count;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

    }


    // search
    public Value search(Key key) {
        Node x = root;
        while (x != null) {
            int comp = key.compareTo(x.key);
            if (comp < 0) x = x.left;
            else if (comp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }


    // insert
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    private Node insert(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);
        int comp = key.compareTo(x.key);
        if (comp < 0) x.left = insert(x.left, key, value);
        else if (comp > 0) x.right = insert(x.right, key, value);
        else x.value = value;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    // min / max
    public Node minNode() {
        Node x = root;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Node maxNode() {
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    // floor / ceiling
    public Node floor(Key key) {
        return floor(root, key);
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int comp = key.compareTo(x.key);
        if (comp == 0) return x;
        else if (comp < 0) return floor(x.left, key);
        else {
            Node t = floor(x.right, key);
            return t != null ? t : x;
        }
    }

    public Node ceil(Key key) {
        return ceil(root, key);
    }

    private Node ceil(Node x, Key key) {
        if (x == null) return null;
        int comp = key.compareTo(x.key);
        if (comp == 0) return x;
        else if (comp > 0) return ceil(x.right, key);
        else {
            Node t = ceil(x.left, key);
            return t != null ? t : x;
        }
    }

    // size
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    // rank
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int comp = key.compareTo(x.key);
        if (comp < 0) return rank(x.left, key);
        else if (comp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    // select
    public Node select(int rank) {
        if (rank < 0 || rank >= size(root)) throw new IllegalArgumentException();
        return select(root, rank);
    }

    private Node select(Node x, int rank) {
        if (x == null) return null;
        int size = size(x.left);
        if (size > rank) return select(x.left, rank);
        else if (size < rank) return select(x.right, rank - size - 1);
        else return x;
    }

    // in ordered iteration
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (x == null) return;
        inorder(x.left);
        System.out.print(x.value + " ");
        inorder(x.right);
    }


    // level ordered iteration
    public void levelOrder() {
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


    // delete
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int comp = key.compareTo(x.key);
        if (comp < 0) x.left = delete(x.left, key);
        else if (comp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
}
