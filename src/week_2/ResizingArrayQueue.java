package week_2;

public class ResizingArrayQueue {

    private String[] array = new String[1];
    private int head = 0;
    private int tail = 0;

    public ResizingArrayQueue() {

    }

    public static void main(String[] args) {
        ResizingArrayQueue resizingArrayQueue = new ResizingArrayQueue();
        resizingArrayQueue.enqueue("abc");
        resizingArrayQueue.enqueue("def");
        resizingArrayQueue.enqueue("ghi");
        resizingArrayQueue.enqueue("jkl");
        resizingArrayQueue.enqueue("mno");

        while (!resizingArrayQueue.isEmpty()) {
            System.out.println(resizingArrayQueue.dequeue() + " " + resizingArrayQueue.getSize());
        }
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(String x) {
        this.array[tail++] = x;
        if (tail == this.array.length) this.resize(array.length * 2);
    }

    public String dequeue() {
        String string = this.array[head];
        this.array[head++] = null;
        if (tail - head == this.array.length / 4) this.resize(this.array.length / 2);
        return string;
    }

    private void resize(int size) {
        String[] copy = new String[size];
        if (tail - head >= 0) System.arraycopy(this.array, head, copy, 0, tail - head);
        tail = tail - head;
        head = 0;
        this.array = copy;
    }

    public int getSize() {
        return tail - head;
    }
}
