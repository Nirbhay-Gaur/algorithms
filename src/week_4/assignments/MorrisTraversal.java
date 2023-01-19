package week_4.assignments;

public class MorrisTraversal {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        MorrisTraversal morrisTraversal = new MorrisTraversal();
        morrisTraversal.inorder(root);
    }

    private static class Node {
        int data;
        Node left = null, right = null;

        public Node(int x) {
            this.data = x;
        }
    }


    public void inorder(Node root) {
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node previous = current.left;
                while (previous.right != current && previous.right != null) {
                    previous = previous.right;
                }
                if (previous.right == null) {
                    previous.right = current;
                    current = current.left;
                } else {
                    previous.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }


}
