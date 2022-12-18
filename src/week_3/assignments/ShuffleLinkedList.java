package week_3.assignments;

public class ShuffleLinkedList {
    private Node<Integer> head = null;
    private Node<Integer> tail = null;

    public static void main(String[] args) {
        ShuffleLinkedList shuffleLinkedList = new ShuffleLinkedList();
        shuffleLinkedList.createList(10);
        shuffleLinkedList.print();
        shuffleLinkedList.shuffle(shuffleLinkedList.head, shuffleLinkedList.tail);
        shuffleLinkedList.print();
    }

    public void print() {
        Node<Integer> x = head;

        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }

        System.out.println(" ");
    }

    public void shuffle(Node<Integer> _head, Node<Integer> _tail) {

        Node<Integer> middle = findMiddle(_head);
        if (middle == _tail) return;
        shuffle(_head, middle);
        shuffle(middle.next, _tail);
        swap(_head, middle, _tail);
    }

    private void swap(Node<Integer> _head, Node<Integer> _middle, Node<Integer> _tail) {
        while (_head.next != null && _head.next.next != null) {
            int value = _head.item;
            _head.item = _head.next.item;
            _head.next.item = value;
            _head = _head.next.next;
        }
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
