package week_1.assignments;

public class SuccessorWithDelete {
    private int[] index;
    private int[] size;
    private int[] successor;

    public SuccessorWithDelete(int n) {
        index = new int[n];
        size = new int[n];
        successor = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
            size[i] = 1;
            successor[i] = i;
        }
    }

    public static void main(String[] args) {
        SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(6);

        successorWithDelete.delete(3);
        System.out.println(successorWithDelete.getSuccessor(2));
        System.out.println(successorWithDelete.getSuccessor(3));
        successorWithDelete.delete(4);
        System.out.println(successorWithDelete.getSuccessor(2));

    }

    private int root(int x) {
        while (index[x] != x) {
            index[x] = index[index[x]];
            x = index[x];
        }
        return x;
    }

    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA > rootB) {
            successor[rootB] = successor[rootA];
        } else {
            successor[rootA] = successor[rootB];
        }
        if (rootA == rootB) return;

        if (size[rootA] > size[rootB]) {
            index[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            index[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    public void delete(int x) {
        if (x == index.length - 1) return;

        this.union(x, x + 1);
    }

    public int getSuccessor(int x) {
        return successor[root(x + 1)];
    }
}
