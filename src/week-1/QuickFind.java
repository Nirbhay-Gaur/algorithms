public class QuickFind {
    private int[] index = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public boolean find(int a, int b) {
        return index[a] == index[b];
    }

    public void union(int a, int b) {
        int aid = index[a];
        int bid = index[b];

        for (int i = 0; i < index.length; i++) {
            if (index[i] == aid) {
                index[i] = bid;
            }
        }
    }
}
