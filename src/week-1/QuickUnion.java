public class QuickUnion {
    private int[] index = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    private int root(int x) {
        while(index[x] != x) x = index[x];
        return x;
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        if(rootA == rootB) return;
        index[rootA] = rootB;
    }
}
