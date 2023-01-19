package week_4.assignments;

public class BSTChecker {
    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BSTChecker bstChecker = new BSTChecker();

        System.out.println(bstChecker.check(root));
    }

    private static class Node {
        int data;
        Node left = null, right = null;

        public Node(int x) {
            this.data = x;
        }
    }

    public boolean check(Node x) {
        if (x.left == null || x.right == null) return true;
        if (x.left.data > x.data) return false;
        if (x.right.data < x.data) return false;

        return check(x.left) && check(x.right);
    }
}
