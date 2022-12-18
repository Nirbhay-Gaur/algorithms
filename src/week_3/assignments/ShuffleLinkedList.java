package week_3.assignments;

public class ShuffleLinkedList {
    private Node<Integer> head = null;
    private Node<Integer> tail = null;

    public static void main(String[] args) {
        ShuffleLinkedList shuffleLinkedList = new ShuffleLinkedList();
        shuffleLinkedList.createList(10);
        shuffleLinkedList.print();
        shuffleLinkedList.shuffle();
        shuffleLinkedList.print();
    }

    public void shuffle() {
        this.head = sort(this.head);
    }

    private Node<Integer> sort(Node<Integer> _head) {
        if (_head == null || _head.next == null) return _head;
        Node<Integer> slow = _head;
        Node<Integer> fast = _head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node<Integer> left = _head;
        Node<Integer> right = slow.next;
        slow.next = null;

        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private Node<Integer> merge(Node<Integer> _left, Node<Integer> _right) {
        Node<Integer> aux = new Node<>();
        Node<Integer> l = _left;
        Node<Integer> r = _right;
        Node<Integer> current = aux;
        while (l != null && r != null) {
            int random = Math.random() > 0.5 ? 1 : 0;
            if (random == 0) {
                current.next = l;
                current = current.next;
                l = l.next;
            } else {
                current.next = r;
                current = current.next;
                r = r.next;
            }
        }
        if (l != null) current.next = l;
        else if (r != null) current.next = r;
        return aux.next;
    }

    public void print() {
        Node<Integer> x = head;

        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }

        System.out.println(" ");
    }


    private Node<Integer> findMiddle(Node<Integer> head) {
        Node<Integer> middle = head;
        Node<Integer> end = head;

        while (end.next != null && end.next.next != null) {
            end = end.next.next;
            middle = middle.next;
        }

        return middle;
    }

    public void createList(int N) {
        for (int i = 0; i < N; i++) {
            this.push(i + 1);
        }
    }

    private void push(int i) {
        Node<Integer> oldTail = tail;
        tail = new Node<>();
        tail.item = i;
        tail.next = null;
        if (head == null) head = tail;
        else oldTail.next = tail;
    }

    private int pop() {
        int item = head.item;
        head = head.next;
        return item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        public Node() {
            this.item = null;
            this.next = null;
        }
    }
}
