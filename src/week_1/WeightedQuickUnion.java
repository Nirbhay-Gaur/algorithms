package week_1;

public class WeightedQuickUnion {

    private final int[] index = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private final int[] size = new int[10];

    public WeightedQuickUnion() {

        // initialize size of each node as 1
        for (int i = 0; i < index.length; i++) {
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
    }

    private int root(int x) {
        while (index[x] != x) {
            // Path compression single-line optimization. Flatten tree while traversing to root.
            // Make every other node in the path point to its grandparent.
            index[x] = index[index[x]];
            x = index[x];
        }
        return x;
    }

    public boolean find(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        if (rootA == rootB) return;

        if (size[rootA] > size[rootB]) {
            index[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            index[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }
}