package week_1.assignments;

public class UnionFindCanonical {
    private int[] index;
    private int[] size;
    private int[] maxItem;

    public UnionFindCanonical(int n) {
        index = new int[n];
        size = new int[n];
        maxItem = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
            maxItem[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        UnionFindCanonical unionFindCanonical = new UnionFindCanonical(6);
        unionFindCanonical.union(0, 5);
        unionFindCanonical.union(1, 3);
        unionFindCanonical.union(3, 0);
        unionFindCanonical.union(1, 4);

        System.out.println(unionFindCanonical.find(0));
        System.out.println(unionFindCanonical.find(1));
        System.out.println(unionFindCanonical.find(2));
        System.out.println(unionFindCanonical.find(3));
        System.out.println(unionFindCanonical.find(4));
        System.out.println(unionFindCanonical.find(5));

    }

    private int root(int x) {
        while (index[x] != x) {
            index[x] = index[index[x]];
            x = index[x];
        }
        return x;
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA > rootB) {
            maxItem[b] = rootA;
        } else {
            maxItem[a] = rootB;
        }

        if (connected(a, b)) return;
        if (size[rootA] > size[rootB]) {
            index[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            index[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    public int find(int x) {
        while (maxItem[x] != x) {
            maxItem[x] = maxItem[maxItem[x]];
            x = maxItem[x];
        }
        return x;
    }
}