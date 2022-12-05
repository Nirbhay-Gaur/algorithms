package week_2;

public class ResizingArrayStack {

    private String[] array = new String[1];
    private int n = 0;

    public ResizingArrayStack() {
    }

    public static void main(String[] args) {
        ResizingArrayStack resizingArrayStack = new ResizingArrayStack();
        resizingArrayStack.push("abc");
        resizingArrayStack.push("def");
        resizingArrayStack.push("ghi");
        resizingArrayStack.push("jkl");

        while (!resizingArrayStack.isEmpty()) {
            System.out.println(resizingArrayStack.pop() + " " + resizingArrayStack.n);
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }


    public void push(String x) {
        if (n == array.length - 1) resizeArray(2 * array.length);
        array[n++] = x;
    }

    public String pop() {
        String item = array[--n];
        array[n] = null;
        if (n > 0 && n == array.length / 4) resizeArray(array.length / 2);
        return item;
    }

    public void resizeArray(int size) {
        String[] copy = new String[size];
        if (n >= 0) System.arraycopy(array, 0, copy, 0, n);
        array = copy;
    }
}
